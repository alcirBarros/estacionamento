package br.com.estacionamento.service.service;

import br.com.estacionamento.service.model.Placa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import br.com.estacionamento.service.repository.PlacaRepository;

@Service
public class PlacaService {

    @Autowired
    private PlacaRepository placaRepository;

    public Placa save(Placa placa) {
        return placaRepository.save(placa);
    }

    public Iterable<Placa> findAll() {
        return placaRepository.findAll();
    }

    public Iterable<Placa> findAllByPlaca(String placa) {
        return placaRepository.findAllByPlaca(placa);
    }

    public Optional<Placa> findById(Integer id) {
        return placaRepository.findById(id);
    }
}
