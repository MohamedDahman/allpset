package at.refugeecode.jacksparrow;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class Jacksparrow {

    @Value("${TiaDalama}")
    String TiaDalamaUrl;

    @GetMapping("jacksparrow")
    String getCoins(){

        RestTemplate  restTemplate = new RestTemplate();

        ResponseEntity<String> forEntity = null;
        try {
            forEntity = restTemplate.getForEntity(TiaDalamaUrl, String.class);
        } catch (RestClientException e) {
            System.out.println("there problem with connect TiaDalama");
            return "there problem with connect TiaDalama";
            //e.printStackTrace();
        }
        String coinUrl = forEntity.getBody();

        ResponseEntity<String> forEntity1 = null;
        try {
            forEntity1 = restTemplate.getForEntity(coinUrl, String.class);
        } catch (RestClientException e) {
            System.out.println("there problem with connect Dutchman");
            return "there problem with connect Dutchman";


        }

        return forEntity1.getBody();
    }

}
