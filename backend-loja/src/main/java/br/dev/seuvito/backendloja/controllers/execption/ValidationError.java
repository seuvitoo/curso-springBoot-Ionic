package br.dev.seuvito.backendloja.controllers.execption;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends AppError {
    private static final long serialVersionUID = 1L;

    private final List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}



