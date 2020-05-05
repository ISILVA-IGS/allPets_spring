package br.com.allpets.AllPets.components;

import br.com.allpets.AllPets.entidades.Service;
import br.com.allpets.AllPets.modelos.FileAllpetsM;
import br.com.allpets.AllPets.repositories.FileOutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.List;

@Component
public class Recording {

    private String status;
    @Autowired
    private FileOutputRepository repository;

    public String gravaLista() {
        FileWriter arq = null;
        Formatter saida = null;
        boolean deuRuim = false;
        String nomeArquivo = "layoutSaida.txt";

        try {
            arq = new FileWriter(nomeArquivo, false);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            status = "Erro ao abrir arquivo";
            System.exit(1);
        }

        try {
            int registroHeader = 00;
            String tipoArquivo = "Serviço";
            LocalDate agora = LocalDate.now();
            String dataCriacao = String.valueOf(agora);
            int anoReferencia = 2020;
            int versao = 1;
            saida.format(" %d %s %d %s %d \n", registroHeader, tipoArquivo, anoReferencia, dataCriacao, versao);

            for (int i = 0; i < repository.findAllFile().size(); i++) {
                int registroMain = 2;
                FileAllpetsM a = repository.findAllFile().get(i);
                saida.format(" %d %d %s %s %7.2f \n", registroMain, a.getIdService(),
                         a.getStartTime(), a.getStopTime(),a.getValue());
            }

            int tipoTrailer = 1;
            int quantidadeServico = 4;

            saida.format(" %d %d \n", tipoTrailer, quantidadeServico);

            status = "Gravado com sucesso";
        }
        catch (FormatterClosedException erro) {
            status = "Erro ao gravar no arquivo";
            deuRuim= true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                status = "Erro ao fechar arquivo.";
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
        return status;
    }
}
