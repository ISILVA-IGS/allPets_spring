package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.DownloadEntity;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DownloadEntityController {
    @RequestMapping(value = "/downloads")

    @GetMapping("/search")
    public HttpEntity<?> dowload() {




        return new DownloadEntity(null,
                "8787" + ".pdf");
    }
}
