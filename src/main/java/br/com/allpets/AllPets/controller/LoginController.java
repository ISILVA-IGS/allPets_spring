package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository usuarioRepository;
    Integer varificationCode = 999999;

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

    @PostMapping("/logout")
    public ResponseEntity<?>  logout() {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("logout feito com sucesso");
    }

    @PostMapping("/logar")
    public ResponseEntity<?>  logar(@RequestBody User user) {
        User dataUser = usuarioRepository.findByEmail(user.getEmail());
        String sessionToken = null;

        if(dataUser == null || !dataUser.getPassword().equals(user.getPassword())){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("usuário ou senha errados");

        }else{
            if(dataUser.getTwoFactor() ){
                if(user.getTwoFactorCode() != null && !user.getTwoFactorCode().equals(varificationCode)){
                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .body("codigo de varificação errado !");
                }else if(user.getTwoFactorCode() == null) {
                    RestTemplate restTemplate = new RestTemplate();
                    Random rand = new Random();
                    varificationCode = rand.nextInt(9999);

                    String message = "AllPets: seu codigo de vereficação: " +  varificationCode;
                    String number = "11"+ dataUser.getWhatsapp();

                    String url = String.format("https://1ly1suchu8.execute-api.us-west-2.amazonaws.com/development/?number=%s&message=%s", number, message);
                    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

                    return ResponseEntity
                            .status(HttpStatus.FORBIDDEN)
                            .body("autenticação em dois fatores ativa, codigo enviado para o numero cadastrado ");
                }


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
