package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.dao.CuidadorDAO;
import br.com.allpets.AllPets.dao.DonoDAO;
import br.com.allpets.AllPets.repository.CuidadorRepository;
import br.com.allpets.AllPets.repository.DonoRepository;
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
    public CuidadorDAO create(@RequestBody CuidadorDAO cuidadorDAO){
        return repository.save(cuidadorDAO);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity update(@PathVariable("id") long id,
                                 @RequestBody CuidadorDAO cuidadorDAO) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cuidadorDAO.getNome());
                    record.setSenha(cuidadorDAO.getSenha());
                    record.setEspecialidade(cuidadorDAO.getEspecialidade());
                    record.setGraduacao(cuidadorDAO.getGraduacao());
                    record.setQtdAnimais(cuidadorDAO.getQtdAnimais());
                    record.setValorHora(cuidadorDAO.getValorHora());
                    CuidadorDAO updated = repository.save(record);
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
