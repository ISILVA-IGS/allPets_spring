package br.com.allpets.AllPets.service;

import br.com.allpets.AllPets.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;


}
