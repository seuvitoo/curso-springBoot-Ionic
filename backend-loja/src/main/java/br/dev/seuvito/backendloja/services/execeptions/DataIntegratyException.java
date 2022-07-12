package br.dev.seuvito.backendloja.services.execeptions;

public class DataIntegratyException extends RuntimeException {

    private static final long serialVersionUID = 1l;

    public DataIntegratyException(String msg) {
        super(msg);
    }

    public DataIntegratyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
