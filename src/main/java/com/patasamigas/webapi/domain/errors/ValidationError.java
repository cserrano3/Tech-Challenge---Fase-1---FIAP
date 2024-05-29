package com.patasamigas.webapi.domain.errors;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError extends StandardError {
    private List<ValidationErrorMessage> validationErrorMessages = new ArrayList<ValidationErrorMessage>();

    public void addMessage(final ValidationErrorMessage message) {
        this.validationErrorMessages.add(message);
    }

}

