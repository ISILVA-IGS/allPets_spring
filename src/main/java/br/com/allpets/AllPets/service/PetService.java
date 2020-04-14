package br.com.allpets.AllPets.service;

import br.com.allpets.AllPets.model.Animal;
import br.com.allpets.AllPets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public List all() {
        return this.repository.findAll();
    }

    public Long score() {
        return this.repository.count();
    }

    public Animal createPet(Animal newPet) {
        return this.repository.save(newPet);
    }

    public Boolean hasPetId(Integer id) {
        return this.repository.existsById(id);
    }

    public Optional<Animal> onePet(Integer id) {
        return this.repository.findById(id);
    }

    public void deletePetId(Integer id) {
        this.repository.deleteById(id);
    }

}
