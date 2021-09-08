package br.com.chogataoMeli.DataTransferObject;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import br.com.chogataoMeli.model.Categoria;

public class CategoriaDto {

	@NotBlank
	private String nome;
	
	@Positive
	private Long idCategoriaMae;


	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setIdCategoriaMae(Long idCategoriaMae) {
		this.idCategoriaMae = idCategoriaMae;
	}
	
	
	
	public Long getIdCategoriaMae() {
		return idCategoriaMae;
	}

	@Deprecated
	public CategoriaDto() {
	
	}

	public CategoriaDto(Categoria categoria) {
		this.nome = categoria.getNome();
		this.idCategoriaMae = categoria.getId();
	}


	


	public Categoria toModel(EntityManager em) {
		Categoria categoria = new Categoria(nome);
		if(idCategoriaMae != null) {
			Categoria categoriaMae = em.find(Categoria.class, idCategoriaMae);
			Assert.notNull(categoriaMae, "O ID da categoria mãe precisa ser válido");
			categoria.setMae(categoriaMae);
			
		}
		return categoria;
	}





	
}
