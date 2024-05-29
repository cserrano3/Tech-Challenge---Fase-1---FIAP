package com.patasamigas.webapi.application.useCases;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RecoverTokenDTO;
import com.patasamigas.webapi.adapter.controllers.dtos.user.UserLoginDTO;
import com.patasamigas.webapi.application.gateways.user.AuthenticationGateway;

public class AuthenticateUserUseCase {
    private final AuthenticationGateway authenticationRepository;

    public AuthenticateUserUseCase(AuthenticationGateway authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }


    public RecoverTokenDTO authenticateUser(UserLoginDTO userLogin) {
        return authenticationRepository.authenticateUser(userLogin);
    }

}
