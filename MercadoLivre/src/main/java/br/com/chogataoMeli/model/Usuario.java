package br.com.chogataoMeli.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;

@Entity
@Table(name = "usuario")
public class Usuario implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> perfil = new  ArrayList<>();
	
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


	
	public Usuario() {
	
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



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return perfil;
	}



	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.senha;
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}






	

}
