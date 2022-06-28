package br.dev.seuvito.backendloja.services;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.repositories.CategoriaRepository;
import br.dev.seuvito.backendloja.services.execeptions.DataIntegratyException;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) throws ObjectNotFoundException {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new br.dev.seuvito.backendloja.services.execeptions.ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) throws ObjectNotFoundException {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) throws ObjectNotFoundException {
        find(id);
        try {
            repo.deleteById(id);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegratyException("você nao pode excluir uma categoria com produtos");

        }
    }
}
