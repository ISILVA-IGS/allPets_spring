package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.components.PlanoAnual;
import br.com.allpets.AllPets.components.PlanoMensal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/planos")
public class PlanoController {

    private PlanoMensal planoMensal = new PlanoMensal();
    private PlanoAnual planoAnual = new PlanoAnual();

    @CrossOrigin
    @GetMapping("/assinatura/{tipo}")
    public ResponseEntity assinaturaPlano(@PathVariable String tipo){
        String tipoUpper = tipo.toUpperCase();
        if(tipoUpper.equals("MENSAL")){
            String status = planoMensal.assinou(true);
            return ResponseEntity.ok(status);
        }else if(tipoUpper.equals("ANUAL")){
            String status = planoAnual.assinou(true);
            return ResponseEntity.ok(status);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping("/cancelamento/{tipo}")
    public ResponseEntity cancelamentoPlano(@PathVariable String tipo){
        String tipoUpper = tipo.toUpperCase();
        if(tipoUpper.equals("MENSAL")){
            String status = planoMensal.cancelamento(true);
            return ResponseEntity.ok(status);
        }else if(tipoUpper.equals("ANUAL")){
            String status = planoAnual.cancelamento(true);
            return ResponseEntity.ok(status);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
