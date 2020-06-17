package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.clients.*;
import br.com.allpets.AllPets.modelos.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired // injetando um cliente Feign
    private RatingClient clienteRating;


    @GetMapping
    public ResponseEntity listRating() {
        List<Rating> ratingController = clienteRating.listRating();

        if (ratingController!=null) {
            return ok(ratingController);
        } else {
            return notFound().build();
        }
    }
}
