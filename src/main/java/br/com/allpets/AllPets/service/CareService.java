package br.com.allpets.AllPets.service;

import br.com.allpets.AllPets.model.User;
import br.com.allpets.AllPets.repository.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareService {

    @Autowired
    private CareRepository repository;

    public List all() {
        return this.repository.findAll();
    }

    public Long score() {
        return this.repository.count();
    }

    public User createCare(User newCare) {
        return this.repository.save(newCare);
    }

    public Boolean hasCareId(Integer id) {
        return this.repository.existsById(id);
    }

    public Optional<User> oneCare(Integer id) {
        return this.repository.findById(id);
    }

    public void deleteCareId(Integer id) {
        this.repository.deleteById(id);
    }


}
