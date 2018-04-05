package Refugeescode.at.Mp5.The.Marathon;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
class EndPorintTest {


    @LocalServerPort
    private int  port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @SpyBean
    private EndPorint endPorint;

    private String urlendpoint="/runners";
    private String urlWinner="/winner";


    private String url,winurl;

    @BeforeEach
    void before(){
        url="http://localhost:"+port+urlendpoint;
        winurl="http://localhost:"+port+urlendpoint;
    }


    @Test
    void get() {
        ResponseEntity<Runner[]> forEntity = testRestTemplate.getForEntity(url, Runner[].class);
        List<Runner> runners= Arrays.asList(forEntity.getBody());
        Assert.assertTrue(runners.isEmpty());
        verify(endPorint).get();

    }

    @Test
    void post() {
        Runner runner = new Runner();
        runner.setName("Khalil");
        runner.setTime(Duration.ofHours(1).plusMinutes(1));
        ResponseEntity<Runner> runnerResponseEntity = testRestTemplate.postForEntity(url, runner, Runner.class);
        Assert.assertEquals(runnerResponseEntity.getBody().getName(),runner.getName());
        verify(endPorint).post(any(Runner.class));

        ResponseEntity<Runner[]> forEntity = testRestTemplate.getForEntity(url, Runner[].class);
        List<Runner> runners= Arrays.asList(forEntity.getBody());

        Assert.assertFalse(runners.isEmpty());
        Assert.assertEquals(runners.get(0).getName(),runner.getName());
        verify(endPorint).get();

    }

    @Test
    void getWinner() {

        Runner runner = new Runner();
        runner.setName("Mohamed");
        runner.setTime(Duration.ofHours(2).plusMinutes(20));
        testRestTemplate.postForEntity(url, runner, Runner.class);

        Runner runner1 = new Runner();
        runner1.setName("Dahman");
        runner1.setTime(Duration.ofHours(0).plusMinutes(20));
        testRestTemplate.postForEntity(url, runner1, Runner.class);

        ResponseEntity<Runner> forEntity = testRestTemplate.getForEntity(urlWinner, Runner.class);
        Runner runners= forEntity.getBody();
        Assert.assertEquals("Dahman",runners.getName());
        verify(endPorint).getWinner();

    }
}