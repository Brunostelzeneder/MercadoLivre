package br.com.chogataoMeli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.chogataoMeli.model.Categoria;

@Component
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	

}
