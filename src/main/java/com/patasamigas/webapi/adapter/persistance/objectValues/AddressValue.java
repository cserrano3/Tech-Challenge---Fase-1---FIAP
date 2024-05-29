package com.patasamigas.webapi.adapter.persistance.objectValues;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressValue {
    @NotBlank
    @Size(min = 3, max = 50)
    private String city;

    @NotBlank
    @Size(min = 3, max = 50)
    private String state;

    @NotBlank
    @Size(min = 3, max = 50)
    private String zip;

    @NotNull
    private int number;

    @NotBlank
    @Size(min = 3, max = 50)
    private String country;

    @NotBlank
    @Size(min = 3, max = 50)
    private String street;


}
