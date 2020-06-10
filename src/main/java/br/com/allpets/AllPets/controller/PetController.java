package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.Animal;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity allCare() {
        if (this.repository.count() > 0) {
            return ResponseEntity.ok(this.repository.findAll());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity onePet(@PathVariable Integer id){
        Optional<Animal> queryPet = this.repository.findById(id);

        if(queryPet.isPresent()){
            return ResponseEntity.ok(queryPet.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @RequestBody Animal animal) {
        if(this.repository.existsById(id)){
            animal.setIdPet(id);
            this.repository.save(animal);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity createPet(@RequestBody Animal newPet) {

        return ResponseEntity.created(null).body(this.repository.save(newPet));
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deletePetId(@PathVariable Integer id){
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
