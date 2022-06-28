package br.dev.seuvito.backendloja.controllers;

import br.dev.seuvito.backendloja.entities.Categoria;
import br.dev.seuvito.backendloja.services.CategoriaService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable Integer id) throws ObjectNotFoundException {
        Categoria resultoBusca = service.find(id);
        return ResponseEntity.ok().body(resultoBusca);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) throws ObjectNotFoundException {
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
