package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;

    @CrossOrigin
    @PutMapping
    public ResponseEntity<?> updateService(
            @RequestParam(required = true) Integer idService,
            @RequestParam(required = true) Integer status){

        Service service = serviceRepository.getOne(idService);

        service.setStatus(status);

        serviceRepository.saveAndFlush(service);

        return ResponseEntity.noContent().build();
    };

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> newService(@RequestBody Service service) {

        service.setStatus(0);
        serviceRepository.save(service);

        return ResponseEntity.created(null).body(service);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<?> listService(
            @RequestParam(required = false) Integer idOwner,
            @RequestParam(required = false) Integer idCare,
            @RequestParam(required = false) Integer status,
            @RequestParam(required = false) boolean ord

    ){
        User owner = new User();
        User care = new User();
        owner.setIdUser(idOwner);
        care.setIdUser(idCare);

        Service service = new Service();
        service.setStatus(status);
        service.setFkOwner(owner);
        service.setFkCare(care);

        if(ord){
            return ResponseEntity.ok(serviceRepository.findAllId());
        }else{
            return ResponseEntity.ok(this.serviceRepository.findAll(Example.of(service)));
        }
    };





}
