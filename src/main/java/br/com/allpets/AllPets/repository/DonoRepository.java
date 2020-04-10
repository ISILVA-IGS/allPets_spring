package br.com.allpets.AllPets.repository;

import br.com.allpets.AllPets.model.Dono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<Dono, Long> {}
