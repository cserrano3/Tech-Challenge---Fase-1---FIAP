package com.patasamigas.webapi.adapter.persistance.entities;

import java.util.ArrayList;
import java.util.List;

public class PetHealthRecordBuilder {
    private PetHealthRecordEntity petHealthRecord;

    public PetHealthRecordEntity rescuedPetHealthRecord(PetEntity pet) {
        List<ConsultRecordEntity> consultRecordHistory = new ArrayList<>();
        consultRecordHistory.add(new ConsultRecordEntity());

        List<VaccineRecordEntity> vaccineHistory = new ArrayList<>();
        vaccineHistory.add(new VaccineRecordEntity());

        this.petHealthRecord = new PetHealthRecordEntity();

        petHealthRecord.setPet(pet);
        petHealthRecord.setConsultHistory(consultRecordHistory);
        petHealthRecord.setVaccineHistory(vaccineHistory);

        return petHealthRecord;
    }
}
