package com.patasamigas.webapi.domain;

import com.patasamigas.webapi.domain.objectValues.PetSpecies;
import com.patasamigas.webapi.domain.objectValues.PetStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pet {
    private UUID id;
    private PetStatus adoptionStatus;
    private PetSpecies species;
    private String name;
    private int age;
    private List<PetHealthRecord> petHealthRecords;

    public Pet(UUID id, String name, PetSpecies petSpecies, int age,  PetStatus adoptionStatus) {
        this.id = id;
        this.name = name;
        this.species = petSpecies;
        this.age = age;
        this.adoptionStatus = adoptionStatus;

    }
}
