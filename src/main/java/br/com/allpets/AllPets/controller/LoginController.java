package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.User;
import br.com.allpets.AllPets.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Date;
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

    @PostMapping("teste")
    public ResponseEntity<?>  logar(@RequestBody User user) {
        User dataUser = usuarioRepository.findByEmail(user.getEmail());
        String sessionToken = null;


        if(dataUser == null || !dataUser.getPassword().equals(user.getPassword())){
            dataUser = null;
        }else{
            sessionToken = dataUser.getIdUser().toString() + ":" + new Date().toString();
            sessionToken = (Base64.getEncoder().encodeToString(sessionToken.getBytes()));
        }


        return ResponseEntity
                .status(HttpStatus.OK)
                .header("sessionToken", sessionToken)
                .body(dataUser);


    }
}
