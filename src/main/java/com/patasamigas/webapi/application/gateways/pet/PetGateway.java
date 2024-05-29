package com.patasamigas.webapi.application.gateways.pet;

import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.domain.Pet;


public interface PetGateway {

    Pet registerPet(CreatePetDTO petData);

}
