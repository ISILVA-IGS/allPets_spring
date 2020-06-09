package br.com.allpets.AllPets.services;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    public List all() {
        User owner = new User();

        owner.setTypeUser(1);
        return
                this.repository.findAll(Example.of(owner));
    }

    public Long score() {
        return this.repository.count();
    }

    public User createOwner(User newOwner) {
        return this.repository.save(newOwner);
    }

    public List findById(int id) { return this.repository.findById(id);}

    public boolean existsById(int id) { return this.repository.existsById(id);}

    public Optional<User> oneOwner(Integer id) {
        return this.repository.findById(id);
    }

    public void deleteOwnerId(Integer id) {
        this.repository.deleteById(id);
    }

    public void putOwner(User user) {
        this.repository.save(user);
    }

    public List allListUser() {
        return this.repository.findAllListUser();
    }
}
