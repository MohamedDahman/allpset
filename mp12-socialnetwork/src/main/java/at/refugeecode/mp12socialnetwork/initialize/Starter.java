package at.refugeecode.mp12socialnetwork.initialize;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Starter {
    @Bean
    ApplicationRunner applicationRunner(){
        return  args -> {

        };
    }
}
