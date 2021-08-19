package br.dev.seuvito.backendloja.repositories;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}


