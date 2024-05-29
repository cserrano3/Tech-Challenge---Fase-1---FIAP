package com.patasamigas.webapi.domain;

import com.patasamigas.webapi.adapter.persistance.entities.PetEntity;
import com.patasamigas.webapi.domain.objectValues.VeterinarianInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultRecord {
    private UUID id;
    private PetHealthRecord petHealthRecord;
    private LocalDate consultDate;
    private LocalDate nextConsultDate;
    private VeterinarianInfo veterinarianInfo;
    private String reasonForVisit;
    private String Diagnoses;
    private String medicationsPrescribed;


}
