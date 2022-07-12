package br.dev.seuvito.backendloja.repositories;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.entities.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {


}


