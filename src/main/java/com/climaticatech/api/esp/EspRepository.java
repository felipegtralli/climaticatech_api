package com.climaticatech.api.esp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspRepository extends JpaRepository<Esp32Data, Long> { 
    public Optional<Esp32Data> findTopByOrderByHorarioDesc();

    public List<Esp32Data> findAllByOrderByHorarioDesc();
}
