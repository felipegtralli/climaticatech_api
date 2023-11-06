package com.climaticatech.api.esp;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Esp32Data {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String umidade;
    private String temperatura;
    private String luminosidade;
    @Column(columnDefinition="timestamp default NOW()", insertable=false)
    private LocalDateTime horario;

    public Esp32Data() {}

    public Esp32Data(String umidade, String temperatura, String luminosidade) {
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.luminosidade = luminosidade;
    }

    public Esp32Data(long id, String umidade, String temperatura, String luminosidade, LocalDateTime horario) {
        this.id = id;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.luminosidade = luminosidade;
        this.horario = horario;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUmidade() {
        return this.umidade;
    }

    public void setUmidade(String umidade) {
        this.umidade = umidade;
    }

    public String getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getLuminosidade() {
        return this.luminosidade;
    }

    public void setLuminosidade(String luminosidade) {
        this.luminosidade = luminosidade;
    }

    public LocalDateTime getHorario() {
        return this.horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", umidade='" + getUmidade() + "'" +
            ", temperatura='" + getTemperatura() + "'" +
            ", luminosidade='" + getLuminosidade() + "'" +
            ", horario='" + getHorario() + "'" +
            "}";
    }

}
