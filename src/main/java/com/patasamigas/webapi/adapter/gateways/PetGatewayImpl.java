package com.patasamigas.webapi.adapter.gateways;

import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.adapter.mappers.pet.PetEntityMapper;
import com.patasamigas.webapi.adapter.persistance.PetRepository;
import com.patasamigas.webapi.adapter.persistance.entities.PetBuilder;
import com.patasamigas.webapi.adapter.persistance.entities.PetEntity;
import com.patasamigas.webapi.application.gateways.pet.PetGateway;
import com.patasamigas.webapi.domain.Pet;

import jakarta.transaction.Transactional;
import java.util.Optional;


public class PetGatewayImpl implements PetGateway {


    private final PetRepository petRepository;
    private final PetEntityMapper petEntityMapper;
    private final PetBuilder petBuilder;


    public PetGatewayImpl(PetRepository petRepository, PetEntityMapper petEntityMapper, PetBuilder petBuilder) {
        this.petRepository = petRepository;
        this.petEntityMapper = petEntityMapper;
        this.petBuilder = petBuilder;

    }


    @Override
    @Transactional
    public Pet registerPet(CreatePetDTO petData)  {
        PetEntity newPet = this.petBuilder.buildRescuedPet(petData);
        this.petRepository.save(newPet);
        Pet registeredPet =  this.petEntityMapper.toPetDomain((Optional.of(newPet)));

        return registeredPet;

    }




}
