package org.artemanha.ecommerce.seguranca;

import java.util.Optional;

import org.artemanha.ecommerce.model.Usuario;
import org.artemanha.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = userRepository.findByNomeCompleto(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + "Not found"));
		return user.map(UserDetailsImpl::new).get();
	}

}
