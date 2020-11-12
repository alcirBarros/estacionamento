package br.com.estacionamento.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "placa")
public class Placa {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "placa", length = 8)
    private String placa;

    @JsonIgnore
    @CreationTimestamp
    @Column(name = "data_Hora_entrada")
    private LocalDateTime dataHoraEntrada;

    @JsonIgnore
    @Column(name = "data_Hora_saida")
    private LocalDateTime dataHoraSaida;

    @Column(name = "tempo_permanencia")
    private String tempoPermanencia;

    @Column(name = "pago")
    private Boolean pago = Boolean.FALSE;

    @Column(name = "saiu")
    private Boolean saiu = Boolean.FALSE;

    public Placa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public String getTempoPermanencia() {
        Duration d = Duration.between(dataHoraEntrada, dataHoraSaida != null ? dataHoraSaida : LocalDateTime.now());
        long hours = d.toHours();
        int minutes = (int) ((d.getSeconds() % (60 * 60)) / 60);
        int seconds = (int) (d.getSeconds() % 60);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void setTempoPermanencia(String tempoPermanencia) {
        this.tempoPermanencia = tempoPermanencia;
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }

    public Boolean getSaiu() {
        return saiu;
    }

    public void setSaiu(Boolean saiu) {
        this.saiu = saiu;
    }

}
