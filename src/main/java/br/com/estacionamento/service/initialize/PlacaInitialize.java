package br.com.estacionamento.service.initialize;

import br.com.estacionamento.service.model.Placa;
import br.com.estacionamento.service.repository.PlacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PlacaInitialize implements CommandLineRunner {

    @Autowired
    private PlacaRepository placaRepository;

    @Override
    public void run(String... args) throws Exception {

        {
            Placa placa = new Placa();
            placa.setPlaca("AAA-1234");
            placaRepository.save(placa);
        }

        {
            Placa placa = new Placa();
            placa.setPlaca("AAA-1234");
            placaRepository.save(placa);
        }

        {
            Placa placa = new Placa();
            placa.setPlaca("AAA-1234");
            placaRepository.save(placa);
        }

    }
}
