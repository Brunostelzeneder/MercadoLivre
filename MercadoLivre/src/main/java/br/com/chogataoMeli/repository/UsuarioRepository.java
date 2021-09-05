package br.com.chogataoMeli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.chogataoMeli.model.Usuario;

@Component
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
