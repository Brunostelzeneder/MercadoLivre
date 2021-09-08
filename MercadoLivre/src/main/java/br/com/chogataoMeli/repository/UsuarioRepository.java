package br.com.chogataoMeli.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chogataoMeli.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByLogin(String login);
	
	

}
