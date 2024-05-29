package com.patasamigas.webapi.adapter.controllers.exceptions;

import com.patasamigas.webapi.domain.errors.StandardError;
import com.patasamigas.webapi.domain.errors.ValidationError;
import com.patasamigas.webapi.domain.errors.ValidationErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class InvalidUserExceptionHandler extends ResponseEntityExceptionHandler {
    private StandardError error = new StandardError();

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final ConstraintViolationException e, HttpServletRequest request) {
        HttpStatus statusCode = HttpStatus.BAD_REQUEST;

        ValidationError validationError = new ValidationError();
        validationError.setTimestamp(Instant.now());
        validationError.setStatus(statusCode.value());
        validationError.setError("InvalidUserError");
        validationError.setMessage(e.getMessage());

        for(ConstraintViolation violation : e.getConstraintViolations()) {

            System.out.println(violation.getConstraintDescriptor());
            ValidationErrorMessage errorMessage = new ValidationErrorMessage(violation.getInvalidValue().toString(), violation.getMessage());
            validationError.addMessage(errorMessage);
        }

        return  ResponseEntity.status(statusCode).body(validationError);
    }

}
