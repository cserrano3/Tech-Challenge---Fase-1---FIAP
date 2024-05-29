package com.patasamigas.webapi.adapter.persistance.objectValues;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VeterinarianInfoValue {
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    @Size(min = 3, max = 50)
    private String clinic;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "number", column = @Column(name = "house_number")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "zip", column = @Column(name = "zip_code"))
    })
    private AddressValue clinicAddress;

    @NotBlank
    @Size(max = 15)
    private String phoneNumber;
}
