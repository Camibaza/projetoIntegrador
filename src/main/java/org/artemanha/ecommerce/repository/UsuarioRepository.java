package org.artemanha.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.artemanha.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Fernanda
 * @since 1.0
 * Criação do UsuarioRepository
 *
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List <Usuario> findAllByUsuarioContainingIgnoreCase(String usuario);

	public List <Usuario> findAllByEmailContainingIgnoreCase(String Email);

	public Optional<Usuario> findByUsuario(String userName);

	public Optional<Usuario> findAllByUsuario(String usuario);
}
	
	