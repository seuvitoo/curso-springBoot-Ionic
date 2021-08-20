package br.dev.seuvito.backendloja.entities;

import br.dev.seuvito.backendloja.entities.enums.EstadoPagamento;

import java.util.Date;

public class PagamentoBoleto extends Pagamento {
    private static final long serialVersionUID = 1l;


    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoBoleto() {

    }

    public PagamentoBoleto(Integer id, EstadoPagamento estadoPagamento,
                           Pedido pedido, Date dataVencimento, Date dataPagamento) {
        super(id, estadoPagamento);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
