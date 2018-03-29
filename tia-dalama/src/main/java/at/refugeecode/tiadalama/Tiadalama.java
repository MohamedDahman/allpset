package at.refugeecode.tiadalama;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Tiadalama {

    @Value("${urlDutchman}")
    String DutchmanUrl;

    @GetMapping("/Tiadalama")
    String getDutchmanurl(){
        return DutchmanUrl;
    }

}
