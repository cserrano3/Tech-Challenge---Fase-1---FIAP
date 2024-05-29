package com.patasamigas.webapi.adapter.controllers.dtos.user;

import com.patasamigas.webapi.domain.objectValues.Address;
import com.patasamigas.webapi.domain.objectValues.ERole;

public record RegisterUserDTO(
        String email,
        String password,
        ERole role,
        String name,
        String lastName,
        Address address,
        String CPF
    ) {}
