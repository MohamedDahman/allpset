package at.refugeecode.mp9mypersonaltodolist.repository;

import at.refugeecode.mp9mypersonaltodolist.model.ToDo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ApplicantRepository extends MongoRepository<ToDo,String> {


  //  List<ToDo> findall();
    Optional<ToDo> findById(String id);
    void deleteById(String id);



}
