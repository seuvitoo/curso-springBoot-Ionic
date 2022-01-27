package br.dev.seuvito.backendloja.services;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.repositories.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;


    public Categoria buscarCategoriaPorId(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new br.dev.seuvito.backendloja.services.execeptions.ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }
}
