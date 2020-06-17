package br.com.allpets.AllPets.clients;
import br.com.allpets.AllPets.modelos.Rating;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "Rating", url = "http://localhost:8081")
public interface RatingClient {

    @GetMapping("/rating")
    List<Rating> listRating ();
}
