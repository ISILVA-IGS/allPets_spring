package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.DownloadEntity;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teste")
public class DownloadEntityController {

    @GetMapping
    public HttpEntity<?> dowload() {




        return new DownloadEntity(null,
                "8787" + ".pdf");
    }
}
