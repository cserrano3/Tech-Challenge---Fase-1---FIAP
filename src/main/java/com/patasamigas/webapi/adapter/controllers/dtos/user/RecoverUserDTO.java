package com.patasamigas.webapi.adapter.controllers.dtos.user;

import com.patasamigas.webapi.domain.objectValues.ERole;

import java.util.List;

public record RecoverUserDTO(Long id, String email, List<ERole> roles) {}
