package com.patasamigas.webapi.domain;

import com.patasamigas.webapi.domain.objectValues.VeterinarianInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VaccineRecord {
    private UUID id;
    private PetHealthRecord petHealthRecord;
    private String vaccineType;
    private LocalDate vaccineDate;
    private LocalDate nextDueDate;
    private VeterinarianInfo veterinarianInfo;

}
