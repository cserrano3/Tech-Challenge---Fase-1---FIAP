package com.patasamigas.webapi.adapter.gateways;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RecoverTokenDTO;
import com.patasamigas.webapi.adapter.controllers.dtos.user.UserLoginDTO;
import com.patasamigas.webapi.adapter.persistance.entities.UserDetailsEntity;
import com.patasamigas.webapi.application.gateways.user.AuthenticationGateway;
import com.patasamigas.webapi.application.gateways.user.JWTTokenServiceGateway;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class AuthenticationGatewayImpl implements AuthenticationGateway {

    private final JWTTokenServiceGateway jwtTokenService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationGatewayImpl(JWTTokenServiceGateway jwtTokenService, AuthenticationManager authenticationManager) {
        this.jwtTokenService = jwtTokenService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public RecoverTokenDTO authenticateUser(UserLoginDTO userLogin) {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userLogin.email(), userLogin.password());

        Authentication authentication = this.authenticationManager.authenticate(token);

        UserDetailsEntity userDetails = (UserDetailsEntity) authentication.getPrincipal();

        return new RecoverTokenDTO(jwtTokenService.generateToken(userDetails));

    }
}
