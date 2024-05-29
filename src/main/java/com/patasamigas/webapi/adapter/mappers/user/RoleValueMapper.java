package com.patasamigas.webapi.adapter.mappers.user;

import com.patasamigas.webapi.adapter.persistance.objectValues.RoleValue;
import com.patasamigas.webapi.domain.objectValues.ERole;

import java.util.ArrayList;
import java.util.List;

public class RoleValueMapper {

    public List<RoleValue> toRoleValueeList(ERole role) {

        List<RoleValue> roleValueList = new ArrayList<>();
        roleValueList.add(new RoleValue(role));

        return roleValueList;

    }

}
