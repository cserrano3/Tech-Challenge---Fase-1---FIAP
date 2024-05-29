package com.patasamigas.webapi.adapter.controllers.dtos.pet;

import com.patasamigas.webapi.domain.objectValues.PetSpecies;

public record CreatePetDTO(String name, PetSpecies petSpecies, int age) {

}
