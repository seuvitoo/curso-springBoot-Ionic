package br.dev.seuvito.backendloja.repositories;

import br.dev.seuvito.backendloja.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}


