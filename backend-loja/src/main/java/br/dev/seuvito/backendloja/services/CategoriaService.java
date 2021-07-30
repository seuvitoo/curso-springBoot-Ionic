package br.dev.seuvito.backendloja.services;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscarCategoriaPorId(Integer id) {

        Optional<Categoria> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
