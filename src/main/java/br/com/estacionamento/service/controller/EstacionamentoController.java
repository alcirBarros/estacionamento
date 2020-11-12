package br.com.estacionamento.service.controller;

import br.com.estacionamento.service.dto.PlacaDTO;
import br.com.estacionamento.service.model.Placa;
import br.com.estacionamento.service.service.PlacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/estacionamentos")
public class EstacionamentoController {

    @Autowired
    private PlacaService placaService;

    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<Iterable<Placa>> findAllByPlaca(@RequestBody @Valid PlacaDTO placaDTO) {
        String placa = placaDTO.placa;
        Iterable<Placa> placaIterable = placaService.findAllByPlaca(placa);
        return new ResponseEntity<>(placaIterable, HttpStatus.OK);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity save(@RequestBody @Valid PlacaDTO placaDTO) {
        Placa placa = placaService.save(placaDTO.createInstance());
        return new ResponseEntity<>(placa, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/saida",method = {RequestMethod.PUT})
    public ResponseEntity saida(@PathVariable("id") Integer id) {
        return placaService.findById(id).map((Placa placa) -> {
            placa.setSaiu(true);
            placa.setDataHoraSaida(LocalDateTime.now());
            Placa updated = placaService.save(placa);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/{id}/pagamento",method = {RequestMethod.PUT})
    public ResponseEntity pagamento(@PathVariable("id") Integer id) {
        return placaService.findById(id).map((Placa placa) -> {
            placa.setPago(true);
            Placa updated = placaService.save(placa);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }
}
