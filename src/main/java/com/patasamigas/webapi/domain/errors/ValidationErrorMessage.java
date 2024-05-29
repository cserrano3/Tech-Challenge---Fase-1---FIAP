package com.patasamigas.webapi.domain.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidationErrorMessage {
    private String invalidValue;
    private String message;
    
}
