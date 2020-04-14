package br.com.allpets.AllPets.service;

import br.com.allpets.AllPets.model.User;
import br.com.allpets.AllPets.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List all() {
        return this.repository.findAll();
    }

    public Long score() {
        return this.repository.count();
    }

    public User createOwner(User newOwner) {
        return this.repository.save(newOwner);
    }

    public Boolean hasOwnerId(Integer id) {
        return this.repository.existsById(id);
    }

    public Optional<User> oneOwner(Integer id) {
        return this.repository.findById(id);
    }

    public void deleteOwnerId(Integer id) {
        this.repository.deleteById(id);
    }

}
