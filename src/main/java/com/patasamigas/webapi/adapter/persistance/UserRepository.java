package com.patasamigas.webapi.adapter.persistance;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.adapter.persistance.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByCPF(String CPF);
    Optional<UserEntity> findByEmail(String email);
}
