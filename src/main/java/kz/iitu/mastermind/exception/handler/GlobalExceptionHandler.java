package kz.iitu.mastermind.exception.handler;

import kz.iitu.mastermind.exception.NotFoundException;
import kz.iitu.mastermind.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e)
    {
        log.error("Exception handled: "+ e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("NOT_FOUND_ERROR", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e)
    {
        log.error("Exception handled: "+ e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("NullPointerException", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleAnyException(Exception e)
    {
        log.error("Exception handled: "+ e.getMessage(), e);
        ErrorResponse errorResponse = new ErrorResponse("INTERNAL_SERVER_ERROR","A system error has occurred.");

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
