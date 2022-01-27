package br.dev.seuvito.backendloja.controllers;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.services.CategoriaService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Integer id) throws ObjectNotFoundException {
        Categoria resultoBusca = service.buscarCategoriaPorId(id);

        return ResponseEntity.ok().body(resultoBusca);
    }

    public ResponseEntity<Void> insert(Categoria obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }


}
