package com.patasamigas.webapi.application.useCases;

import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.adapter.gateways.PetGatewayImpl;
import com.patasamigas.webapi.application.gateways.pet.PetGateway;
import com.patasamigas.webapi.domain.Pet;


public class CreatePetUseCase {
    private final PetGatewayImpl petRepository;

    public CreatePetUseCase(PetGatewayImpl petRepository) {
        this.petRepository = petRepository;
    }

    public Pet createPet(CreatePetDTO petDTO) {
        Pet pet =  this.petRepository.registerPet(petDTO);
        return pet;
    }
}
