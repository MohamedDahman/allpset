package at.refugeecode.mp14encoder;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Controller
@RequestMapping("/encoder")
public class Encoder {


    @GetMapping
    String  page(){
        return  "encoder";
    }

    @PostMapping
    String sendMessage(@Valid String encoder, Model model){
            String mesage=encoder;
            System.out.println(encoder);
            RestTemplate restTemplate = new RestTemplate();
            String collector="";
            for (String x:mesage.split("")) {
                ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8083/mores/", x, String.class);
                ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8083/mores/", String.class);
                collector += forEntity.getBody();
            }
            model.addAttribute("enocdeMessage",collector);
            return "encoder";

    }


}
