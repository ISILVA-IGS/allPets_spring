package br.com.allpets.AllPets.repository;

import br.com.allpets.AllPets.model.Care;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareRepository extends JpaRepository<Care, Integer> {}
