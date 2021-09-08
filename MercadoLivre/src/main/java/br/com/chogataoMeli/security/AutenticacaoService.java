package br.com.chogataoMeli.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.chogataoMeli.model.Usuario;
import br.com.chogataoMeli.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	Optional<Usuario> usuario =usuarioRepository.findByLogin(username);
		if(usuario.isPresent()) { 
			return (UserDetails) usuario.get();
		}
	
		throw new UsernameNotFoundException("Dados inválidos");
	}

}
