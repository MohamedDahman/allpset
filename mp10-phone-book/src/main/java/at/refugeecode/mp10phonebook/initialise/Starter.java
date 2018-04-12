package at.refugeecode.mp10phonebook.initialise;

import at.refugeecode.mp10phonebook.model.Address;
import at.refugeecode.mp10phonebook.model.Person;
import at.refugeecode.mp10phonebook.persistence.ApplicantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Starter {

    @Bean
    ApplicationRunner applicationRunner(ApplicantRepository applicantRepository){
        return args -> {
            applicantRepository.deleteAll();

            Person mohamed = new Person();
            mohamed.setName("Mohamed Dahman");
            mohamed.setAddress(new Address("2700 - Wiener Neustadt Pottendorfer Strasse20"));
            applicantRepository.save(mohamed);

            Person sami=new Person();
            sami.setName("Yamen");
            sami.setAddress(new Address("2700 - Wiener Neustadt Adlergasse 7"));
            applicantRepository.save(sami);
        };
    }
}
