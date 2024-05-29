package com.patasamigas.webapi.config;

import com.patasamigas.webapi.adapter.gateways.AuthenticationGatewayImpl;
import com.patasamigas.webapi.adapter.gateways.UserGatewayImpl;
import com.patasamigas.webapi.adapter.mappers.user.*;
import com.patasamigas.webapi.adapter.persistance.UserRepository;
import com.patasamigas.webapi.application.gateways.user.JWTTokenServiceGateway;
import com.patasamigas.webapi.application.gateways.user.UserGateway;
import com.patasamigas.webapi.application.useCases.AuthenticateUserUseCase;
import com.patasamigas.webapi.application.useCases.RegisterUserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class UserConfig {

    @Bean
    AddressObjectValueMapper createAddressObjectValueMapper() {
        return new AddressObjectValueMapper();
    }

    @Bean
    UserEntityMapper createAdopterDBMapper(AddressObjectValueMapper addressValueMapper) {
        return new UserEntityMapper(addressValueMapper);
    }

    @Bean
    AddressValueMapper createAddressValueMapper() {
        return new AddressValueMapper();
    }

    @Bean
    RoleValueMapper createRoleValueMapper() {
        return new RoleValueMapper();
    }

    @Bean
    UserDTOMapper createUserDTOMapper (AddressValueMapper addressDTOMapper, RoleValueMapper roleValueMapper) {
        return new UserDTOMapper(addressDTOMapper, roleValueMapper);
    }

    @Bean
    UserGatewayImpl createUserGatewayImpl(UserRepository userRepository,
                                             UserEntityMapper mapper,
                                             UserDTOMapper dtoMapper,
                                             SecurityConfig securityConfig) {
        return new UserGatewayImpl(userRepository, mapper, dtoMapper, securityConfig);
    }

    @Bean
    AuthenticationGatewayImpl createAuthenticationGatewayImpl(JWTTokenServiceGateway jwtTokenService, AuthenticationManager authenticationManager) {
        return new AuthenticationGatewayImpl(jwtTokenService, authenticationManager);
    }

    @Bean
    RegisterUserUseCase createRegisterUserUseCase(UserGateway userRepository) {
        return new RegisterUserUseCase(userRepository);
    }

    @Bean
    AuthenticateUserUseCase authenticateUserUseCase(AuthenticationGatewayImpl authenticationRepository) {
        return new AuthenticateUserUseCase(authenticationRepository);
    }

}
