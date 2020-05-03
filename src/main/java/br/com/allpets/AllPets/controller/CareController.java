package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.services.CareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cuidadores")
public class CareController {

    @Autowired
    private CareService service;

    @GetMapping
    public ResponseEntity allCare() {
        if (this.service.score() > 0) {
            return ResponseEntity.ok(this.service.all());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity oneCare(@PathVariable Integer id){
        Optional<User> queryCare = this.service.oneCare(id);

        if(queryCare.isPresent()){
            return ResponseEntity.ok(queryCare.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity createCare(@RequestBody User newCare) {
        this.service.createCare(newCare);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCareId(@PathVariable Integer id){
        if(this.service.hasCareId(id)){
            this.service.deleteCareId(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
