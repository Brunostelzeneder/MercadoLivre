package br.com.chogataoMeli.DataTransferObject;

import java.util.List;
import java.util.stream.Collectors;

import br.com.chogataoMeli.model.Usuario;

public class UsuarioDto {

	private String login;
	
	private String senha;
	
	

	public UsuarioDto() {
		
	}

	public UsuarioDto(Usuario usuario) {
		
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
//	public static List<UsuarioDto> converter11(List<Usuario> usuario) {
//		return usuario.stream().map(UsuarioDto::new).collect(Collectors.toList());
//	}
	
	public Usuario converter() {
		return new Usuario(login, senha);
	}
	
}
