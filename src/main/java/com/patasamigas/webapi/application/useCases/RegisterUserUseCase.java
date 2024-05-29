package com.patasamigas.webapi.application.useCases;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.application.gateways.user.UserGateway;
import com.patasamigas.webapi.domain.User;


public class RegisterUserUseCase {
    private final UserGateway userRepository;

    public RegisterUserUseCase(UserGateway userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(RegisterUserDTO userData) {
        return this.userRepository.save(userData);
    }
}
