package br.org.generation.ex2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ex2Controller {
	
	@RequestMapping("/ex2")
	public String ex2() {
		return "Meu objetivo é conseguir entender tudo que foi proposto na aula";
	}
}
