package com.patasamigas.webapi.adapter.mappers.pet;

import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.adapter.persistance.entities.PetEntity;
import com.patasamigas.webapi.adapter.persistance.objectValues.PetSpeciesValue;

import java.util.ArrayList;
import java.util.List;

public class CreatedPetDTOMapper {

    public PetEntity toPetEntity(CreatePetDTO petDTO)  {
        List<PetSpeciesValue> petSpeciesList = new ArrayList<>();
        petSpeciesList.add(new PetSpeciesValue(petDTO.petSpecies()));

        return new PetEntity(petDTO.name(), petDTO.age(),petSpeciesList);
    }

}
