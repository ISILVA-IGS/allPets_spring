package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.model.Dono;
import br.com.allpets.AllPets.repository.DonoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cadastro/dono")
public class DonoController {
    private DonoRepository repository;

    DonoController(DonoRepository donoRepository) {
        this.repository = donoRepository;
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
    public Dono create(@RequestBody Dono dono){
        return repository.save(dono);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody Dono dono) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(dono.getNome());
                    record.setIdade(dono.getIdade());
                    record.setSenha(dono.getSenha());
                    Dono updated = repository.save(record);
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
