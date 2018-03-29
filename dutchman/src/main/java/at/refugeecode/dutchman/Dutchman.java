package at.refugeecode.dutchman;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dutchman {

    private String cheast ="You Can Take the Money";


    @GetMapping("/Dutchman")
    String getCheast(){
        return  cheast;
    }

}
