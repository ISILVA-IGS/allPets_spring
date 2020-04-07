package br.com.allpets.AllPets.repository;

import br.com.allpets.AllPets.dao.DonoDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonoRepository extends JpaRepository<DonoDAO, Long> {}
