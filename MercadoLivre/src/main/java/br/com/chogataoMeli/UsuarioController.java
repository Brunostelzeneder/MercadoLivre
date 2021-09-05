package br.com.chogataoMeli;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.chogataoMeli.model.Usuario;
import br.com.chogataoMeli.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UsuarioController {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> cadastraUser(@RequestBody @Valid Usuario usuario ) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));

}
}
