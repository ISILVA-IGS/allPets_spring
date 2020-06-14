package br.com.allpets.AllPets.services;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.CareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CareService {

    @Autowired
    private CareRepository repository;

    public List all() {
        User care = new User();

        care.setTypeUser(2);
        return
                this.repository.findAll(Example.of(care));
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

    public void putCare(User user) {
        this.repository.save(user);
    }

    public boolean existsById(int id) { return this.repository.existsById(id);}

    public void deleteCareId(Integer id) {
        this.repository.deleteById(id);
    }


}
