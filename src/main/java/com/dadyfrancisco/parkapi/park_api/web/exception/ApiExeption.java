package com.dadyfrancisco.parkapi.park_api.web.exception;

import com.dadyfrancisco.parkapi.park_api.exception.UsernameUniqueViolationException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExeption {
    private static final Logger log = LoggerFactory.getLogger(ApiExeption.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroMessage>MethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                      HttpServletRequest request,
                                                                      BindingResult result){
        log.error("Api Error -", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErroMessage(request,HttpStatus.UNPROCESSABLE_ENTITY,"campos invalido(s)",result));

    }

    @ExceptionHandler(UsernameUniqueViolationException.class)
    public ResponseEntity<ErroMessage>MethodArgumentNotValidException(RuntimeException ex,
                                                                      HttpServletRequest request
                                                                      ){
        log.error("Api Error -", ex);
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErroMessage(request,HttpStatus.CONFLICT,ex.getMessage()));

    }
}
