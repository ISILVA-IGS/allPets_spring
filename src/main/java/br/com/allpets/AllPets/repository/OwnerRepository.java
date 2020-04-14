package br.com.allpets.AllPets.repository;

import br.com.allpets.AllPets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<User, Integer> {}
