package br.dev.seuvito.backendloja.controllers;

import br.dev.seuvito.backendloja.entities.Pedido;
import br.dev.seuvito.backendloja.services.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscarCategoria(@PathVariable Integer id) throws ObjectNotFoundException {
        Pedido resultoBusca = service.buscarPedidoPorId(id);

        return ResponseEntity.ok().body(resultoBusca);
    }


}
