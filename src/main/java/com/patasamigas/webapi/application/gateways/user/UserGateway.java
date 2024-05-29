package com.patasamigas.webapi.application.gateways.user;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.domain.User;

public interface UserGateway {
    User save(RegisterUserDTO user);
}
