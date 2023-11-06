package com.climaticatech.api.esp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspService {
    private EspRepository repository;

    @Autowired
    public EspService(EspRepository repository) {
        this.repository = repository;
    }

    public List<Esp32Data> getAllData() {
        return repository.findAll();
    }

    public List<Esp32Data> getAllDataInv() {
        return repository.findAllByOrderByHorarioDesc();
    }

    public void postData(Esp32Data esp32Data) {
        if(repository.count() > 50) {
            List<Long> ids = new ArrayList<>();
            long id = repository.findTopByOrderByHorarioDesc().get().getId() - 50;
            for(long i = id; i < (id + 25); i++) {
                ids.add(i);
            }
            repository.deleteAllById(ids);
        }
        repository.save(esp32Data);
    }

    public Esp32Data getLastData() {
        Esp32Data data = repository.findTopByOrderByHorarioDesc().get();
        if(data == null) return null;
        return data;
    }

    public void deleteAllData() {
        repository.deleteAll();
    }
}
