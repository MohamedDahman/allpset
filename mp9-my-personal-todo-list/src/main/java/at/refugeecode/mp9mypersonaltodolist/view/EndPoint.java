package at.refugeecode.mp9mypersonaltodolist.view;


import at.refugeecode.mp9mypersonaltodolist.model.ToDo;
import at.refugeecode.mp9mypersonaltodolist.repository.ApplicantRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class EndPoint {

    private ApplicantRepository applicantRepository;


    public EndPoint(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }


    @GetMapping
    List<ToDo> findAll(){
        return  applicantRepository.findAll();
    }

    @PostMapping
    ToDo save(@RequestBody ToDo toDo) {
        return applicantRepository.save(toDo);
    }



    @PostMapping("/{id}/done")
    void save(@PathVariable String id) {
        Optional<ToDo> byId = applicantRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setDone(true);
            applicantRepository.save(byId.get());
        }
    }

}
