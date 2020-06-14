package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.Animal;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity allCare() {
        if (repository.count() > 0) {
            return ok(repository.findAll());
        }else {
            return noContent().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity onePet(@PathVariable Integer id){
        Optional<Animal> queryPet = this.repository.findById(id);

        if(queryPet.isPresent()){
            return ok(queryPet.get());
        }else{
            return notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @RequestBody Animal animal) {
        if(this.repository.existsById(id)){
            animal.setIdPet(id);
            this.repository.save(animal);
            return ok().build();
        }else{
            return notFound().build();
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity createPet(@RequestBody Animal newPet) {

        return created(null).body(this.repository.save(newPet));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deletePetId(@PathVariable Integer id){
        repository.deleteAll();
        return ok().build();
    }

}
