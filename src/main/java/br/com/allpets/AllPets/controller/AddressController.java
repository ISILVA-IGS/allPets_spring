package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.clients.CepClient;
import br.com.allpets.AllPets.entidades.Address;
import br.com.allpets.AllPets.modelos.Cep;
import br.com.allpets.AllPets.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/endereco")
public class AddressController {

    @Autowired
    private AddressRepository repository;

    @Autowired // injetando um cliente Feign
    private CepClient CepClient;


    @CrossOrigin
    @GetMapping
    public ResponseEntity allAddress() {
        if (this.repository.count() > 0) {
            return ResponseEntity.ok(this.repository.findAll());
        }else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity criarEsporte(@RequestBody Address novoAddress) {



        return ResponseEntity.created(null).body(this.repository.save(novoAddress));
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity consultarCep(@PathVariable String cep) {
        Cep cepEncontrado = CepClient.getCep(cep);

        if (cepEncontrado!=null) {
            return ok(cepEncontrado);
        } else {
            return notFound().build();
        }
    }
}
