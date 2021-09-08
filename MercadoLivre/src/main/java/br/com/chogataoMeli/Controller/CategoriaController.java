package br.com.chogataoMeli.Controller;

import java.net.URI;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.chogataoMeli.DataTransferObject.CategoriaDto;
import br.com.chogataoMeli.model.Categoria;
import br.com.chogataoMeli.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class CategoriaController {
	
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@PersistenceContext
	private EntityManager manager;
	

	
	@PostMapping("/cadastrarNovo")
	public ResponseEntity<Categoria> cadastrarNovaCategoria(@RequestBody @Valid CategoriaDto request, UriComponentsBuilder uriBuilder){
		Categoria categoria = request.toModel(manager);
		categoriaRepository.save(categoria);
		URI uri = uriBuilder.path("/cadastrar").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(categoria);
		
	}

}