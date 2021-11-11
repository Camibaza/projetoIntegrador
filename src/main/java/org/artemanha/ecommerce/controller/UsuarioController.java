package org.artemanha.ecommerce.controller;

import java.util.List;

import org.artemanha.ecommerce.model.Usuario;
import org.artemanha.ecommerce.repository.UsuarioRepository;
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
@CrossOrigin("*")

public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/nomeCompleto/{nomeCompleto}")
	public ResponseEntity<List<Usuario>> getByNomeCompleto(@PathVariable String nomeCompleto) {
		return ResponseEntity.ok(repository.findAllByNomeCompletoContainingIgnoreCase(nomeCompleto));
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<List<Usuario>> getByEmail(@PathVariable String email) {
		return ResponseEntity.ok(repository.findAllByEmailContainingIgnoreCase(email));
	}

	@PostMapping
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}

	@PutMapping
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}

	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
