package com.patasamigas.webapi.adapter.gateways;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.adapter.mappers.user.UserDTOMapper;
import com.patasamigas.webapi.adapter.persistance.entities.UserEntity;
import com.patasamigas.webapi.adapter.mappers.user.UserEntityMapper;
import com.patasamigas.webapi.adapter.persistance.UserRepository;
import com.patasamigas.webapi.adapter.persistance.objectValues.RoleValue;
import com.patasamigas.webapi.application.gateways.user.UserGateway;
import com.patasamigas.webapi.config.SecurityConfig;
import com.patasamigas.webapi.domain.User;
import jakarta.validation.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserGatewayImpl implements UserGateway {

    private final UserRepository repository;
    private final UserEntityMapper userEntityMapper;
    private final UserDTOMapper userDTOMapper;
    private final SecurityConfig securityConfig;

    public UserGatewayImpl(
            UserRepository repository,
            UserEntityMapper userEntityMapper,
            UserDTOMapper userDTOMapper,
            SecurityConfig securityConfig) {
        this.repository = repository;
        this.userEntityMapper = userEntityMapper;
        this.userDTOMapper = userDTOMapper;
        this.securityConfig = securityConfig;
    }


    @Override
    public User save(RegisterUserDTO userData) {
        UserEntity newUser = this.userDTOMapper.toUserEntity(userData);

        List<RoleValue> roles = new ArrayList<>();
        roles.add(new RoleValue(userData.role()));
        newUser.setRoles(roles);

        String encryptedPassword = this.securityConfig.passwordEncoder().encode(userData.password());
        newUser.setPassword(encryptedPassword);

        try {
            this.repository.save(newUser);
            return userEntityMapper.toDomain(Optional.of(newUser));
        } catch(ConstraintViolationException e) {
            throw e;
        }

    }
}
