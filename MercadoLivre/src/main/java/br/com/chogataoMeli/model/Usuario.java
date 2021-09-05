package br.com.chogataoMeli.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank(message = "O usuario não pode ser nulo")
	@Email(message = "Precisa ser um email válido")
	private String login;
	
	@NotNull
	@NotBlank(message = "A senha não pode estar vazia")
	@Size(min = 6, message = "A senha deve ter menos de 6 digitos")
	private String senha;
	
	private LocalDateTime criacao = LocalDateTime.now();
	
	 /** 
	  * @param login -> email string no formato de email
	  * @param senha -> senha string no formato de texto limmpo
	  */
	
	public Usuario(String login, String senha) {
		Assert.isTrue(org.springframework.util.StringUtils.hasLength(senha), "A senha não pode ser em branco");
		Assert.isTrue(org.springframework.util.StringUtils.hasLength(login), "O Login não pode ser em branco");
		Assert.isTrue(senha.length() >= 6, "A senha precisa ter mais de 6 caracteres");
		this.login = login;
		this.senha = new BCryptPasswordEncoder().encode(senha);
	}



	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", criacao=" + criacao + "]";
	}



	public Long getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}



	public LocalDateTime getCriacao() {
		return criacao;
	}
	
	

}
