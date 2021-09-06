package br.com.chogataoMeli.GenericValidator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.chogataoMeli.DataTransferObject.UsuarioDto;
import br.com.chogataoMeli.model.Usuario;
import br.com.chogataoMeli.repository.UsuarioRepository;

@Component
public class UnicoEmailValidator implements Validator {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UsuarioDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		UsuarioDto request = (UsuarioDto) target;
		Optional<Usuario> emailCadastrado = usuarioRepository.findByLogin(request.getLogin());
		if(emailCadastrado.isPresent()) {
			errors.rejectValue("Email Já cadastrado no sistema: " +  request.getLogin(), null);
		}
		
	}

}
