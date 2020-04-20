package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.User;
import br.com.allpets.AllPets.repository.LoginRepository;
import br.com.allpets.AllPets.service.LoginService;
import br.com.allpets.AllPets.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository usuarioRepository;

    @GetMapping
    public List<User> listar() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioRepository.saveAndFlush(user));
    }
}
