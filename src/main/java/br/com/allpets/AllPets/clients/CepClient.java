package br.com.allpets.AllPets.clients;

import br.com.allpets.AllPets.modelos.Cep;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "viacep", url = "https://viacep.com.br")
public interface CepClient {

    @GetMapping("/ws/{cep}/json")
    Cep getCep(@PathVariable String cep);

    @GetMapping("/ws/{cep}/xml")
    Cep getCepXml(@PathVariable String cep);
}

