package br.com.allpets.AllPets.repositories;

import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.modelos.FileAllpetsM;
import br.com.allpets.AllPets.modelos.ListUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileOutputRepository extends JpaRepository<Service, Integer> {

    @Query("select new br.com.allpets.AllPets.modelos.FileAllpetsM(a) from Service a")
    List<FileAllpetsM> findAllFile();
}
