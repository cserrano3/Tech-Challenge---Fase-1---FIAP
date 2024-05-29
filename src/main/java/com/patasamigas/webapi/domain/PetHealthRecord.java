package com.patasamigas.webapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetHealthRecord {
   private UUID id;
   private List<ConsultRecord> consultHistory;
   private List<VaccineRecord> vaccineHistory;
   private Pet pet;
}
