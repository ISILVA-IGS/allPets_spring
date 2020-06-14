package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.OwnerRepository;
import br.com.allpets.AllPets.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donos")
public class OwnerController {

    @Autowired
    private OwnerRepository repository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity allOwner() {
        if (repository.count() > 0) {
            return ResponseEntity.ok(repository.findByTypeUser(1));
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity oneOwner(@PathVariable Integer id){
        Optional<User> queryOwner = repository.findById(id);

        if(queryOwner.isPresent()){
            return ResponseEntity.ok(queryOwner.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @RequestBody User updateUser) {
        if(repository.existsById(id)){
            updateUser.setIdUser(id);
            repository.save(updateUser);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity createOwner(@RequestBody User newOwner) {
        repository.save(newOwner);
        return ResponseEntity.created(null).build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwnerId(@PathVariable Integer id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
