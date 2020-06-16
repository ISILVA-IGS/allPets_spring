package br.com.allpets.AllPets.clients;
import br.com.allpets.AllPets.modelos.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "Rating", url = "http://localhost:8081")
public interface RatingClient {

    @GetMapping("/rating")
    Rating listRating ();
}
