package at.refugeecode.mp10phonebook.persistence;

import at.refugeecode.mp10phonebook.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository< Person, Long>{

}
