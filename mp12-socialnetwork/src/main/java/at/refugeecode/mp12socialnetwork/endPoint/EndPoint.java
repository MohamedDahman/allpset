package at.refugeecode.mp12socialnetwork.endPoint;

import at.refugeecode.mp12socialnetwork.model.Person;
import at.refugeecode.mp12socialnetwork.model.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class EndPoint {

    private PersonRepository personRepository;

    public EndPoint(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    List<Person> getAll(){
        return personRepository.findAll();
    }

    @PostMapping
    List<Person> postPerson(@RequestBody Person person){
        personRepository.save(person);
        return personRepository.findAll();
    }

    @PutMapping("/{id1}/friend/{id2}")
    List<Person> addfriend(@PathVariable Long id1, @PathVariable Long id2){
        if (id1 != id2 )
        {
        Optional<Person> byIdPerson = personRepository.findById(id1);
        if (byIdPerson.isPresent()){
            List<Person> friendList = byIdPerson.get().getFriendList();
            Optional<Person> byIdFriend = personRepository.findById(id2);
            if (byIdFriend.isPresent()){
                friendList.add(byIdFriend.get());
                 byIdPerson.get().setFriendList(friendList);
                 personRepository.save(byIdPerson.get());
            }
        }
        }
        return personRepository.findAll();
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    List<Person> unfriend(@PathVariable Long id1, @PathVariable Long id2){
        Optional<Person> byIdPerson = personRepository.findById(id1);
        if (byIdPerson.isPresent()){
            List<Person> friendList = byIdPerson.get().getFriendList();
            Optional<Person> byIdFriend = personRepository.findById(id2);
            if (byIdFriend.isPresent()){
                friendList.remove(byIdFriend.get());
                byIdPerson.get().setFriendList(friendList);
                personRepository.save(byIdPerson.get());
            }
        }
        return personRepository.findAll();
    }

}
