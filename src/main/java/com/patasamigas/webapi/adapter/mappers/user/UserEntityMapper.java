package com.patasamigas.webapi.adapter.mappers.user;

import com.patasamigas.webapi.adapter.persistance.entities.UserEntity;
import com.patasamigas.webapi.domain.User;
import com.patasamigas.webapi.domain.objectValues.Address;
import com.patasamigas.webapi.domain.objectValues.ERole;

import java.util.Optional;

public class UserEntityMapper {

    private  final AddressObjectValueMapper addressValueMapper;

    public UserEntityMapper(AddressObjectValueMapper addressValueMapper) {
        this.addressValueMapper = addressValueMapper;
    }

    public User toDomain(Optional<UserEntity> userEntity) {

        Address mappedAddress = this.addressValueMapper.toObjectValue(userEntity.get().getAddress());

        ERole role = userEntity.get().getRoles().getFirst().getName();

        return new User(userEntity.get().getId(),
                userEntity.get().getName(),
                userEntity.get().getLastName(),
                userEntity.get().getEmail(),
                role,
                userEntity.get().getCPF(),
                userEntity.get().getPassword(),
                mappedAddress
                );
    }

}
