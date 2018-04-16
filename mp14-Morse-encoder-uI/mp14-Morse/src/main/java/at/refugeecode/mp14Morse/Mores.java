package at.refugeecode.mp14Morse;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/mores")
public class Mores {

    String theMessage;

    private String receiverPort;
    private HashMap<String, String> hashMap;

    @GetMapping
    String sendchar(){
        return theMessage;
    }


    @PostMapping
    String mores(@RequestBody String message){
        theMessage = hashMap.get(message);
        return theMessage;
    }



    private String afterhash;

    public Mores() {
        hashMap = new HashMap();

        List<String> letters = Stream.of("a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" "))
                .collect(Collectors.toList());

        List<String> morse = Stream.of(".- / -... / -.-. / -.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / --- / .--. / --.- / .-. / ... / - / ..- / ...- / .-- / -..- / -.-- / --..".split(" / "))
                .collect(Collectors.toList());

        IntStream.range(0, letters.size())
                .forEach(index -> hashMap.put(letters.get(index), morse.get(index)));
        hashMap.put(" ", ",");
    }

}
