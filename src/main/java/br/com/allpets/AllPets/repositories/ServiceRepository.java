package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    @Query(value = "SELECT u FROM Service u ORDER BY idService DESC")
    List<Service> findAllId();

}
