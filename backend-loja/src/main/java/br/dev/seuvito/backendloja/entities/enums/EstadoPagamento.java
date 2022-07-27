package br.dev.seuvito.backendloja.entities.enums;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    CANCELADO(2, "Cancelado"),
    QUITADO(3, "Quitado");

    private final int cod;
    private final String descricao;

    EstadoPagamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (EstadoPagamento x : EstadoPagamento.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Id invalid: " + cod);
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
