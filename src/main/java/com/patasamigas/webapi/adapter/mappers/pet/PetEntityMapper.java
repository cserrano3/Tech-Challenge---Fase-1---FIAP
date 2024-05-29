package com.patasamigas.webapi.adapter.mappers.pet;

import com.patasamigas.webapi.adapter.persistance.entities.PetEntity;
import com.patasamigas.webapi.domain.Pet;
import com.patasamigas.webapi.domain.objectValues.PetSpecies;
import com.patasamigas.webapi.domain.objectValues.PetStatus;

import java.util.Optional;

public class PetEntityMapper {

    public Pet toPetDomain(Optional<PetEntity> petEntity) {

        PetSpecies petSpecies = petEntity.get().getPetSpecies().getFirst().getName();
        PetStatus petStatus = petEntity.get().getPetAdoptionStatus().getFirst().getName();

        return new Pet(petEntity.get().getId(), petEntity.get().getName(), petSpecies, petEntity.get().getAge(), petStatus);
    }
}
