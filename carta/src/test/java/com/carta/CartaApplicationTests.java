package com.carta;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CartaApplicationTests {
	@Autowired
	private AutoRepository autoRepository;

	@Test
	void contextLoads() {
		Long id = 4L;
		
		Auto auto = new Auto();
		auto.setAnno(2020);
		auto.setCapacidad(5);
		auto.setId(id);
		auto.setMarca("NISSAN");
		auto.setPrecio(200000);
		
		
		autoRepository.save(auto);
		
	}

}
