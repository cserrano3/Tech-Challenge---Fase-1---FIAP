package com.patasamigas.webapi.adapter.controllers.exceptions;

import com.patasamigas.webapi.domain.errors.StandardError;
import com.patasamigas.webapi.domain.errors.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.Instant;

@ControllerAdvice
public class SQLExceptionHandler extends ResponseEntityExceptionHandler {
    private StandardError error = new StandardError();

    @ExceptionHandler({SQLException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final SQLException e, HttpServletRequest request) {
        HttpStatus statusCode = HttpStatus.CONFLICT;

        error.setTimestamp(Instant.now());
        error.setStatus(statusCode.value());
        error.setError("UniqueContraintError");
        error.setMessage(e.getMessage());

        return  ResponseEntity.status(statusCode).body(error);
    }

}
