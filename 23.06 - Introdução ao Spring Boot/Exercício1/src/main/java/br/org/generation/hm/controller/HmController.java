package br.org.generation.hm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HmController {
	
	@RequestMapping("/hm")
	public String hm() {
		return "Utilizei a habilidade de Atenção aos detalhes e mentalidade de Persistência";
	}
}
