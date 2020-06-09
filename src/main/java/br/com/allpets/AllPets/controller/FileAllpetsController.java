package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.services.FileAllpetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/arquivo-saida")
public class FileAllpetsController {

    private FileAllpetsService service;

    FileAllpetsController(FileAllpetsService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity consultarSimples() {
        String file = service.fileOutput();

        return file.isEmpty() ? noContent().build() : ok(file);
    }


}
