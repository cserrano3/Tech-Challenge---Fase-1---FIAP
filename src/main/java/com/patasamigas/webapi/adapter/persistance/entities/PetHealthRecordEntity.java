package com.patasamigas.webapi.adapter.persistance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity(name = "PetHealthRecord")
@Table(name = "pet_health_records")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PetHealthRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToMany(mappedBy = "petHealthRecord",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsultRecordEntity> consultHistory;

    @OneToMany(mappedBy = "petHealthRecord")
    private List<VaccineRecordEntity> vaccineHistory;

    @ManyToOne
    @MapKeyColumn(name = "pet_id")
    private PetEntity pet;

}
