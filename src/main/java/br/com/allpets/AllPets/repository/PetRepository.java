package br.com.allpets.AllPets.repository;

import br.com.allpets.AllPets.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Animal, Integer> {}
