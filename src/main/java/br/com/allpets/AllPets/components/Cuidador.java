package br.com.allpets.AllPets.components;

import br.com.allpets.AllPets.entidades.Animal;
import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.entidades.User;
import br.com.allpets.AllPets.repositories.PetRepository;
import br.com.allpets.AllPets.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Cuidador implements ArquivoGrava{

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public void Registro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }

    @Override
    public void grava(User idUser) {
        String nomeArq = "Historico.txt";
        String header = "";
        String corpo = "";
        String corpoDono= "";
        String trailer = "";

        Date dataDeHoje = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        header += String.format("%-5s", "00 SERVIÇO ");
        header += String.format("%-5s", formatter.format(dataDeHoje));
        header += String.format("%-5s", "01");
        Registro(nomeArq, header);

        Service service = new Service();
        User user = new User();
        service.setFkCare(idUser);

        corpo += String.format("%-5s", "02");

        Service serviceFor = serviceRepository.findAll(Example.of(service)).get(0);

        corpo += String.format("%-20s", serviceFor.getFkCare().getName());
        corpo += String.format("%-10s", serviceFor.getFkCare().getAddress().getCity());
        corpo += String.format("%-15s", serviceFor.getFkCare().getAddress().getBairro());
        corpo += String.format("%-15s", serviceFor.getFkCare().getGraduacao());
        corpo += String.format("%05.2f", serviceFor.getFkCare().getValueTime());
        Registro(nomeArq, corpo);

        for(int i = 0; i<serviceRepository.findAll(Example.of(service)).size();i++){
            Service serviceF = serviceRepository.findAll(Example.of(service)).get(i);
            corpoDono = String.format("%-5s", "03");
            corpoDono += String.format("%-20s", serviceF.getFkOwner().getName());
            corpoDono += String.format("%-15s", serviceF.getFkOwner().getAddress().getCity());
            corpoDono += String.format("%-15s", serviceF.getFkOwner().getAddress().getBairro());
            corpoDono += String.format("%-10s" ,serviceF.getFkOwner().getAnimal().getTypePet());
            corpoDono += String.format("%-10s", serviceF.getFkOwner().getAnimal().getName());
            corpoDono += String.format("%-10s", serviceF.getFkOwner().getAnimal().getSize());
            Registro(nomeArq,corpoDono);
        }

        trailer += String.format("%-3s", "04");
        trailer += String.format("%10d",serviceRepository.findAll(Example.of(service)).size());
        Registro(nomeArq,trailer);

    }
}
