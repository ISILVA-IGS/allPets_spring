package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.Animal;
import br.com.allpets.AllPets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping
    public ResponseEntity allCare() {
        if (this.service.score() > 0) {
            return ResponseEntity.ok(this.service.all());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity onePet(@PathVariable Integer id){
        Optional<Animal> queryPet = this.service.onePet(id);

        if(queryPet.isPresent()){
            return ResponseEntity.ok(queryPet.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createPet(@RequestBody Animal newPet) {
        this.service.createPet(newPet);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePetId(@PathVariable Integer id){
        if(this.service.hasPetId(id)){
            this.service.deletePetId(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
