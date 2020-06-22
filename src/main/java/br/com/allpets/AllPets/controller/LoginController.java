package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.LoginRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository usuarioRepository;
    Integer varificationCode = 999999;

    @CrossOrigin
    @GetMapping
    public List<User> listar() {
        return usuarioRepository.findAll();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usuarioRepository.saveAndFlush(user));
    }

    @CrossOrigin
    @PostMapping("/logout")
    public ResponseEntity<?>  logout() {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("logout feito com sucesso");
    }

    @CrossOrigin
    @PostMapping("/logar")
    public ResponseEntity<?>  logar(@RequestBody User user) {
        User dataUser = usuarioRepository.findByEmail(user.getEmail());

        String sessionToken = null;

        if(dataUser == null || !dataUser.getPassword().equals(user.getPassword()) || !dataUser.getTypeUser().equals(user.getTypeUser())){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("usuário ou senha errados");

        }else{
            if(dataUser.getTwoFactor() ){
                    RestTemplate restTemplate = new RestTemplate();
                    Random rand = new Random();
                    varificationCode = rand.nextInt(9999);

                    String number = "11"+ dataUser.getWhatsapp();
                    dataUser.setTwoFactorCode(varificationCode);
                    String url = String.format("http://127.0.0.1:8081/%s/%s",dataUser.getIdUser(),number);
                    ResponseEntity<String> response = restTemplate.postForEntity(url,null, String.class);

                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = null;
                try {
                    root = mapper.readTree(response.getBody());
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                JsonNode code = root.path("code");

                dataUser.setTwoFactorCode(code.asInt());
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(dataUser);
            }

        }
        sessionToken = dataUser.getIdUser().toString() + ":" + new Date().toString();
        sessionToken = (Base64.getEncoder().encodeToString(sessionToken.getBytes()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("sessionToken", sessionToken)
                .body(dataUser);
    }
}
