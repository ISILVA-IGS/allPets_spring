package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.components.Cuidador;
import br.com.allpets.AllPets.entidades.DownloadEntity;
import br.com.allpets.AllPets.entidades.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;


@RestController
@RequestMapping("/arquivo")
public class DownloadEntityController {

    @Autowired
    Cuidador cuidador;

    @CrossOrigin
    @GetMapping
    public HttpEntity<?> dowload(@RequestParam(required = false) User idUser) {

        cuidador.grava(idUser);

        File file = new File("Historico.txt");
        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        }catch(Exception e){
            System.out.println(e);
        }
       file.delete();
        return new DownloadEntity(bFile,
                "Historico" + ".txt");
    }

}

