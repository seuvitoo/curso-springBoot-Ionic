package br.dev.seuvito.backendloja.entities;


import br.dev.seuvito.backendloja.entities.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento {
    private static final long serialVersionUID = 1l;

    private Integer numParcelas;

    public PagamentoCartao() {
    }

    public PagamentoCartao(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }

    public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Pedido pedido, Integer numParcelas) {
        super(id, estadoPagamento, pedido);
        this.numParcelas = numParcelas;
    }

    public Integer getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Integer numParcelas) {
        this.numParcelas = numParcelas;
    }
}
