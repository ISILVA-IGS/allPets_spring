package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Address;
import br.com.allpets.AllPets.entidades.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareRepository extends JpaRepository<User, Integer> {


    List<User> findById(int id);

    boolean existsById(int id);

    List<User> findByAddressCityAndAddressBairroAndTypeUserAndValueTimeLessThanEqual(String city,String bairro
    ,Integer typeUser, Double valueTime);

}
