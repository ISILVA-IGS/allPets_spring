package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.Animal;
import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.ServiceRepository;
import br.com.allpets.AllPets.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceRepository serviceRepository;



    @PostMapping
    public ResponseEntity<?> newService(@RequestBody Service newService) {
        newService.setStatus(1);
        serviceRepository.save(newService);

        return ResponseEntity.created(null).build();
    }



}
