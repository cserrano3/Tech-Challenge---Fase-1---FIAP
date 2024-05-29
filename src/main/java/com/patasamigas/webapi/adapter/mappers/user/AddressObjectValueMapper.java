package com.patasamigas.webapi.adapter.mappers.user;

import com.patasamigas.webapi.adapter.persistance.objectValues.AddressValue;
import com.patasamigas.webapi.domain.objectValues.Address;

public class AddressObjectValueMapper {

    public Address toObjectValue(final AddressValue  address) {
        return new Address(address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZip(),
                address.getNumber(),
                address.getCountry());
    }
}
