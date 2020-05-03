package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Animal, Integer> {}
