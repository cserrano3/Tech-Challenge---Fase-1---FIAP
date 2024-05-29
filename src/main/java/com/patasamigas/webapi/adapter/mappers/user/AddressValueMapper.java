package com.patasamigas.webapi.adapter.mappers.user;

import com.patasamigas.webapi.adapter.persistance.objectValues.AddressValue;
import com.patasamigas.webapi.domain.objectValues.Address;

public class AddressValueMapper {

    public AddressValue toAddressEntity(Address address) {
       return new AddressValue(
                    address.getCity(),
                    address.getState(),
                    address.getZip(),
                    address.getNumber(),
                    address.getCountry(),
                    address.getStreet());
    }

}
