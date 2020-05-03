package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {


}
