package com.patasamigas.webapi.adapter.mappers.user;

import com.patasamigas.webapi.adapter.controllers.dtos.user.RegisterUserDTO;
import com.patasamigas.webapi.adapter.persistance.objectValues.AddressValue;
import com.patasamigas.webapi.adapter.persistance.entities.UserEntity;
import com.patasamigas.webapi.adapter.persistance.objectValues.RoleValue;

import java.util.List;

public class UserDTOMapper {

    private final AddressValueMapper addressDTOMapper;
    private final RoleValueMapper roleValueMapper;

    public UserDTOMapper(AddressValueMapper addressDTOMapper, RoleValueMapper roleValueMapper) {
        this.addressDTOMapper = addressDTOMapper;
        this.roleValueMapper = roleValueMapper;
    }


    public UserEntity toUserEntity(RegisterUserDTO registerUserDTO) {

        AddressValue mappedAddressEntity = this.addressDTOMapper.toAddressEntity(registerUserDTO.address());
        List<RoleValue> mappedRoles = this.roleValueMapper.toRoleValueeList(registerUserDTO.role());


        return  new UserEntity(
                registerUserDTO.email(),
                registerUserDTO.name(),
                registerUserDTO.lastName(),
                registerUserDTO.CPF(),
                mappedRoles,
                mappedAddressEntity,
                registerUserDTO.password());

    }
}
