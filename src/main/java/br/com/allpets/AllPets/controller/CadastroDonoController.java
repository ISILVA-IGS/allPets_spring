package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.dao.DonoDAO;
import br.com.allpets.AllPets.repository.DonoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastro/dono")
public class CadastroDonoController {
    private DonoRepository repository;

    CadastroDonoController(DonoRepository donoRepository) {
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
    public DonoDAO create(@RequestBody DonoDAO donoDAO){
        return repository.save(donoDAO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody DonoDAO donoDAO) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(donoDAO.getNome());
                    record.setIdade(donoDAO.getIdade());
                    record.setSenha(donoDAO.getSenha());
                    DonoDAO updated = repository.save(record);
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
