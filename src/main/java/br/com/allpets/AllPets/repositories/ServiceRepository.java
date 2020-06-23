package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Service;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

    List<Service> findByFkCareIdUserOrderByIdServiceDesc(Integer idUser);

    List<Service> findByFkOwnerIdUserOrderByIdServiceDesc(Integer idUser);
}
