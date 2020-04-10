package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.Cuidador;
import br.com.allpets.AllPets.repository.CuidadorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro/cuidador")
public class CadastroCuidadorController {
    private CuidadorRepository repository;

    CadastroCuidadorController(CuidadorRepository cuidadorRepository) {
        this.repository = cuidadorRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cuidador create(@RequestBody Cuidador cuidador){
        return repository.save(cuidador);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Cuidador cuidador) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cuidador.getNome());
                    record.setSenha(cuidador.getSenha());
                    record.setEspecialidade(cuidador.getEspecialidade());
                    record.setGraduacao(cuidador.getGraduacao());
                    record.setQtdAnimais(cuidador.getQtdAnimais());
                    record.setValorHora(cuidador.getValorHora());
                    Cuidador updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

}
