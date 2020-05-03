package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.services.ListUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/lista-usuario")
public class ListUserController {

    @Autowired
    private ListUserService service;

    @GetMapping
    public ResponseEntity consultarSimples() {
        List users = service.allListUser();

        return users.isEmpty() ? noContent().build() : ok(users);
    }
}
