package com.patasamigas.webapi.domain;

import com.patasamigas.webapi.adapter.persistance.objectValues.AddressValue;
import com.patasamigas.webapi.domain.objectValues.Address;
import com.patasamigas.webapi.domain.objectValues.ERole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private ERole role;
    private String CPF;
    private String password;
    private Address address;

}
