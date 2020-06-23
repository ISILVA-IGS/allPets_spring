package br.com.allpets.AllPets.controller;

import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.CareRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CareControllerTest {

    @Autowired
    CareController controller;

    @MockBean
    CareRepository repository;

    @Test
    void oneCare() {

        Integer id = 77;
        User  usuario = new User();
        usuario.setIdUser(id);
        usuario.setName("Goku");
        usuario.setTypeUser(2);

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(usuario));

        ResponseEntity resposta = controller.oneCare(id);

        assertEquals(200, resposta.getStatusCodeValue(), "O usuario encontrado deve ser 200");

        assertEquals(usuario, resposta.getBody(),"O usuario que o repository retornou deve ser o mesmo do controller");

        Mockito.when(repository.findById(id)).thenReturn(Optional.of(usuario));

        resposta = controller.allCare();

        assertNull(resposta.getBody(), "O corpo da resposta deve ser nulo");

        assertEquals(204,resposta.getStatusCodeValue(),"Consulta sem conteudo deve retornar 204");
    }

    @Test
    void deleteCareId() {
        Integer id = 77;
        User usuario = new User();
        usuario.setIdUser(id);
        usuario.setName("Goku");
        usuario.setTypeUser(2);

        Mockito.when(repository.existsById(id)).thenReturn(true);

        ResponseEntity resposta = controller.deleteCareId(id);

        assertEquals(200, resposta.getStatusCodeValue(), "O  encontrado deve ser 200");

        resposta = controller.allCare();

        assertNull(resposta.getBody(), "O corpo da resposta ");
    }
}