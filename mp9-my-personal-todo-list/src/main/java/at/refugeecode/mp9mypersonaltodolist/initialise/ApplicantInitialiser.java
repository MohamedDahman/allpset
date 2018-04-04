package at.refugeecode.mp9mypersonaltodolist.initialise;

import at.refugeecode.mp9mypersonaltodolist.repository.ApplicantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicantInitialiser {

    @Bean
    ApplicationRunner applicationRunner(ApplicantRepository applicantRepository){
        return args -> {
           // applicantRepository.deleteAll();


        };
    }
}
