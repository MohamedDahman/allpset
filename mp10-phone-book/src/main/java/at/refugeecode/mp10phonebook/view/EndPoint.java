package at.refugeecode.mp10phonebook.view;

import at.refugeecode.mp10phonebook.model.Person;
import at.refugeecode.mp10phonebook.persistence.ApplicantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contacts")
public class EndPoint {

    private ApplicantRepository applicantRepository;


    public EndPoint(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @GetMapping
    List<Person> getall(){
        return applicantRepository.findAll();
    }

}
