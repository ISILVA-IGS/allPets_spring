package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.User;
import br.com.allpets.AllPets.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/donos")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping
    public ResponseEntity allOwner() {
        if (this.service.score() > 0) {
            return ResponseEntity.ok(this.service.all());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity oneOwner(@PathVariable Integer id){
        Optional<User> queryOwner = this.service.oneOwner(id);

        if(queryOwner.isPresent()){
            return ResponseEntity.ok(queryOwner.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createOwner(@RequestBody User newOwner) {
        this.service.createOwner(newOwner);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwnerId(@PathVariable Integer id){
        if(this.service.hasOwnerId(id)){
            this.service.deleteOwnerId(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
