package br.com.estacionamento.service;

import br.com.estacionamento.service.model.Placa;
import br.com.estacionamento.service.service.PlacaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlacaServiceTest {

	@Autowired
	private PlacaService placaService;

	@Test
	public void test01() {
		Iterable<Placa> placaIterable = placaService.findAll();
		assertThat(((Collection<?>) placaIterable).size()).isEqualTo(3);
	}

}
