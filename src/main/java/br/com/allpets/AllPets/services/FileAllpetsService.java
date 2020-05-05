package br.com.allpets.AllPets.services;

import br.com.allpets.AllPets.components.Recording;
import br.com.allpets.AllPets.repositories.FileOutputRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileAllpetsService {

    private FileOutputRepository repository;
    private Recording recording;

    FileAllpetsService(FileOutputRepository fileOutputRepository, Recording recording) {
        this.repository = fileOutputRepository;
        this.recording = recording;
    }

    public Long score() {
        return this.repository.count();
    }

    public List all() {
        return this.repository.findAll();
    }

    public List allListUser() {
        return this.repository.findAllFile();
    }

    public String fileOutput() {
        String status = recording.gravaLista();

        return status;
    }
}
