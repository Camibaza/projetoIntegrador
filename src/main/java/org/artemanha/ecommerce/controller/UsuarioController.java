package org.artemanha.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.artemanha.ecommerce.model.Usuario;
import org.artemanha.ecommerce.repository.UsuarioRepository;
import org.artemanha.ecommerce.model.UserLogin;
import org.artemanha.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	
	
	@PostMapping("/logar")
	public ResponseEntity<org.artemanha.ecommerce.model.UserLogin> Autentication(@RequestBody Optional<org.artemanha.ecommerce.model.UserLogin> user){
		return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarUsuario(usuario));
	}

	
}
