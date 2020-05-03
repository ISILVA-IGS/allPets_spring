package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
