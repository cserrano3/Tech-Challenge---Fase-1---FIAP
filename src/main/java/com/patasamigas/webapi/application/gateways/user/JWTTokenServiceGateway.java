package com.patasamigas.webapi.application.gateways.user;

import com.patasamigas.webapi.adapter.persistance.entities.UserDetailsEntity;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public interface JWTTokenServiceGateway {
    String generateToken(UserDetailsEntity user);
    String getSubjectFromToken(String token);

    default Instant creationDate() {
        return ZonedDateTime.now(ZoneId.of("UTC")).toInstant();
    }

    default Instant expirationDate() {
        return ZonedDateTime.now(ZoneId.of("UTC")).plusHours(4).toInstant();
    }
}
