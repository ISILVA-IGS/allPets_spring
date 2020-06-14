package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Animal;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.modelos.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<User, Integer> {

    List<User> findById(int id);

    boolean existsById(int id);

    List<User> findByTypeUser(Integer typeUser);

}
