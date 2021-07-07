package br.com.lojadegames.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojadegames.model.UsuarioLoginModel;
import br.com.lojadegames.model.UsuarioModel;
import br.com.lojadegames.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLoginModel> logarUsuario (@RequestBody Optional<UsuarioLoginModel> user) {
		return usuarioService.logar(user)
		.map(resp -> ResponseEntity.ok(resp))
		.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> cadastrarUsuario (@RequestBody UsuarioModel user) {
		Optional<UsuarioModel> novoUsuario = usuarioService.cadastrarUsuario(user);
		try {
			return ResponseEntity.ok(novoUsuario.get());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioModel> atualizarUsuario (@RequestBody UsuarioModel user) {
		Optional<UsuarioModel> alterarUsuario = usuarioService.atualizarUsuario(user);
		try {
			return ResponseEntity.ok(alterarUsuario.get());
		}
		catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}