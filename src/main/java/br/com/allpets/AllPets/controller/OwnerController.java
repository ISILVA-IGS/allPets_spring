package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/donos")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @CrossOrigin
    @GetMapping
    public ResponseEntity allOwner() {
        if (this.service.score() > 0) {
            return ResponseEntity.ok(this.service.all());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity oneOwner(@PathVariable Integer id){
        Optional<User> queryOwner = this.service.oneOwner(id);

        if(queryOwner.isPresent()){
            return ResponseEntity.ok(queryOwner.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") int id,
                                 @RequestBody User user) {
        if(this.service.existsById(id)){
            user.setIdUser(id);
            this.service.putOwner(user);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity createOwner(@RequestBody User newOwner) {
        this.service.createOwner(newOwner);
        return ResponseEntity.created(null).build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOwnerId(@PathVariable Integer id){
        if(this.service.existsById(id)){
            this.service.deleteOwnerId(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
