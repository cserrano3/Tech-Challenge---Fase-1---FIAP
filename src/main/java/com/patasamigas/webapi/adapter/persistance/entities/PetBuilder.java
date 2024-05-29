package com.patasamigas.webapi.adapter.persistance.entities;

import com.patasamigas.webapi.adapter.controllers.dtos.pet.CreatePetDTO;
import com.patasamigas.webapi.adapter.persistance.objectValues.PetSpeciesValue;
import com.patasamigas.webapi.adapter.persistance.objectValues.PetStatusValue;
import com.patasamigas.webapi.domain.objectValues.PetStatus;

import java.util.ArrayList;
import java.util.List;

public class PetBuilder {

    private PetEntity petEntity;
    private final PetHealthRecordBuilder petHealthRecordBuilder;

    public PetBuilder(PetHealthRecordBuilder petHealthRecordBuilder) {
        this.petHealthRecordBuilder = petHealthRecordBuilder;
    }

    public PetEntity buildRescuedPet(CreatePetDTO petData) {
        List<PetStatusValue> petStatuses = new ArrayList<>();
        petStatuses.add(new PetStatusValue(PetStatus.AVAILABLE));

        List<PetSpeciesValue> petSpecies = new ArrayList<>();
        petSpecies.add(new PetSpeciesValue(petData.petSpecies()));

        this.petEntity = new PetEntity(petData.name(), petData.age(), petSpecies,petStatuses);

        PetHealthRecordEntity record = this.petHealthRecordBuilder.rescuedPetHealthRecord(petEntity);

        List<PetHealthRecordEntity> historyRecord = new ArrayList<>();
        historyRecord.add(record);
        petEntity.setHealthRecords(historyRecord);

        return petEntity;

    }

}
