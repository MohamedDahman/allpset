package Refugeescode.at.Mp5.The.Marathon;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EndPorint {

    private List<Runner> runners=new ArrayList<>();
//    @RequestMapping("/runners")

    @GetMapping("/runners")
    List<Runner> get(){
        return  runners;
    }


    @PostMapping("/runners")
    Runner post(@RequestBody Runner runner){
        runners.add(runner);
        return  runner;
    }

    @GetMapping("/winner")
    Runner getWinner(){
        Optional<Runner> first = runners.stream()
                .sorted((r1, r2) -> r1.getTime().compareTo(r2.getTime()))
                .findFirst();
        if (first.isPresent()){
            return first.get();
        }
        return  new Runner("Nobody is winner");
    }


}
