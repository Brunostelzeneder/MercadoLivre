package br.com.chogataoMeli.Controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chogataoMeli.DataTransferObject.UsuarioDto;
import br.com.chogataoMeli.GenericValidator.UnicoEmailValidator;
import br.com.chogataoMeli.model.Usuario;
import br.com.chogataoMeli.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UsuarioController {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UnicoEmailValidator unicoEmailValidator;
	
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(unicoEmailValidator);
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioDto> cadastraUser(@RequestBody @Valid UsuarioDto usuarioForm, UriComponentsBuilder uriBuilder ) {
		Usuario usuario = usuarioForm.converter();
		usuarioRepository.save(usuario);
		
		URI uri = uriBuilder.path("/cadastrar").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));

}
}
