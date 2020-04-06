package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.Dono;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface DonoRepository extends JpaRepository< Dono, Long> {


}
