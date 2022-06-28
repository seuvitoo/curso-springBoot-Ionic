package br.dev.seuvito.backendloja.controllers.execption;

import br.dev.seuvito.backendloja.services.execeptions.DataIntegratyException;
import br.dev.seuvito.backendloja.services.execeptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExecptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<AppError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        AppError err = new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegratyException.class)
    public ResponseEntity<AppError> dataIntegraty(DataIntegratyException e, HttpServletRequest request) {

        AppError err = new AppError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
