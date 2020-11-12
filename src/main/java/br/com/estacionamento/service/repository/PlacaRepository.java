package br.com.estacionamento.service.repository;

import br.com.estacionamento.service.model.Placa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacaRepository extends PagingAndSortingRepository<Placa, Integer> {

    Iterable<Placa> findAllByPlaca(String placa);

}
