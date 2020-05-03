package br.com.allpets.AllPets;

import br.com.allpets.AllPets.entidades.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

public class Recording {

    private String status = "";

    public String gravaLista(ListaObj<Service> lista) {
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
            for (int i = 0; i < lista.getTamanho(); i++) {
                Service a = lista.getElemento(i);

                saida.format("%d %d %d %s %s %7.2f ", a.getIdService(),
                        a.getFkOwnerS(), a.getFkCare(), a.getStartTime(), a.getStopTime(),a.getValue());
            }
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
