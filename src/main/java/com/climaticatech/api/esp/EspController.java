package com.climaticatech.api.esp;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.climaticatech.api.exception.DataNotFoundException;

@RestController
public class EspController {
    private EspService service;

    @Autowired
    public EspController(EspService service) {
        this.service = service;
    }

    @GetMapping(path="/api/esp-data")
    public List<Esp32Data> getAllData(@RequestParam(required=false) Boolean inv) {
        if(inv != null && inv == true) return service.getAllDataInv();
        return service.getAllData();
    }

    @PostMapping(path="/api/esp-data")
    public ResponseEntity<Esp32Data> postData(@RequestBody Esp32Data esp32Data) {
        service.postData(esp32Data);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping(path="/api/esp-data")
    public void deleteAllData() {
        service.deleteAllData();
    }

    @GetMapping(path="/api/esp-data/last")
    public Esp32Data lastData() {
        try{
            Esp32Data data = service.getLastData();
            return data;
        }
        catch(NoSuchElementException e){
            throw new DataNotFoundException("no data present");
        }
    }
}
