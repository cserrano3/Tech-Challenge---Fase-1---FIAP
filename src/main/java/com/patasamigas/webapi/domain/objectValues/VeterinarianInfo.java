package com.patasamigas.webapi.domain.objectValues;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VeterinarianInfo {
    private String name;
    private String clinic;
    private Address clinicAddress;
    private String phoneNumber;
}
