package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRepository extends JpaRepository<User, Integer> {}
