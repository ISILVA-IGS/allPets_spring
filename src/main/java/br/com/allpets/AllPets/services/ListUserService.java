package br.com.allpets.AllPets.services;

import br.com.allpets.AllPets.repositories.OwnerRepository;
import br.com.allpets.AllPets.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserService {

    @Autowired
    private OwnerRepository repository;

    public Long score() {
        return this.repository.count();
    }

    public List all() {
        return this.repository.findAll();
    }

    public List allListUser() {
        return this.repository.findAllListUser();
    }


}
