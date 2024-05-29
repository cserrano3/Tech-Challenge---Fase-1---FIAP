package com.patasamigas.webapi.application.gateways.user;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RecoverTokenDTO;
import com.patasamigas.webapi.adapter.controllers.dtos.user.UserLoginDTO;

public interface AuthenticationGateway {
    RecoverTokenDTO authenticateUser(UserLoginDTO userLogin);
}
