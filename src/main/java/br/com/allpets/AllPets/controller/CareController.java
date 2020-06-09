package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.Address;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.AddressRepository;
import br.com.allpets.AllPets.repositories.CareRepository;
import br.com.allpets.AllPets.services.CareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cuidadores")
public class CareController {

    @Autowired
    private CareService service;

    @Autowired
    private CareRepository careRepository;


    @Autowired
    private AddressRepository addressRepository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity allCare() {
        if (this.service.score() > 0) {
            return ResponseEntity.ok(this.service.all());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity oneCare(@PathVariable Integer id){
        Optional<User> queryCare = this.service.oneCare(id);

        if(queryCare.isPresent()){
            return ResponseEntity.ok(queryCare.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/search")
    public ResponseEntity search(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String street)
    {
        Address address = new Address();
        address.setCity(city);
        address.setBairro(street);
        User user = new User();
        user.setAddress(address);
        user.setTypeUser(2);



        List consulta = careRepository.findAll(Example.of(user));

        return consulta.isEmpty() ? noContent().build() : ok(consulta);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity createCare(@RequestBody User newCare) {
        this.service.createCare(newCare);
        return ResponseEntity.created(null).build();
    }

    @CrossOrigin
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
