package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.modelos.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<User, Integer> {

    @Query("select new br.com.allpets.AllPets.modelos.ListUser(a) from User a")
    List<ListUser> findAllListUser();
}
