package br.com.estacionamento.service.dto;

import br.com.estacionamento.service.model.Placa;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PlacaDTO {

    @Pattern(regexp = "[A-Z]{3}-[0-9]{4}", message = "Informe a placa no formato: 'AAA-9999'")
    @NotNull(message = "Informa o número da placa.")
    public String placa;

    public Placa createInstance(){
        Placa placa = new Placa();
        placa.setPlaca(this.placa);
        return placa;
    }
}