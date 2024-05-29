package com.patasamigas.webapi.adapter.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.patasamigas.webapi.adapter.persistance.entities.UserDetailsEntity;
import com.patasamigas.webapi.application.gateways.user.JWTTokenServiceGateway;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenServiceService implements JWTTokenServiceGateway {
    private static final String SECRET_KEY = "B15C86EA9815621CAD1BA1FF5135D6AA"; // Chave secreta utilizada para gerar e verificar o token
    private static final String ISSUER = "web-api"; // Emissor do token

    public String generateToken(UserDetailsEntity user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

            String createdToken = JWT.create()
                    .withIssuer(ISSUER)
                    .withIssuedAt(creationDate())
                    .withExpiresAt(expirationDate())
                    .withSubject(user.getUsername())
                    .sign(algorithm);

            return createdToken;
        } catch (JWTCreationException exception){
            throw new JWTCreationException("Error while generating token", exception);
        }
    }

    public String getSubjectFromToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            throw new JWTVerificationException("Invalid or expired token");
        }
    }
}