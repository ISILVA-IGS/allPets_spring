package br.com.allpets.AllPets.components;

import br.com.allpets.AllPets.entidades.User;
import org.springframework.stereotype.Component;

@Component
public interface ArquivoGrava {

    void Registro(String nomeArq, String registro);

    void grava(User idUser);

}
