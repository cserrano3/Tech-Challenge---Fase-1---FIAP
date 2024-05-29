package com.patasamigas.webapi.adapter.persistance.entities;

import com.patasamigas.webapi.adapter.persistance.objectValues.PetSpeciesValue;
import com.patasamigas.webapi.adapter.persistance.objectValues.PetStatusValue;
import com.patasamigas.webapi.domain.PetHealthRecord;
import com.patasamigas.webapi.domain.objectValues.PetSpecies;
import com.patasamigas.webapi.domain.objectValues.PetStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "Pets")
@Table(name = "pets")
public class PetEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Getter
    @Setter
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="pet_species",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name="pet_species_id"))
    @Setter
    @Getter
    @NotBlank
    private List<PetSpeciesValue> petSpecies;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="pet_statuses",
            joinColumns = @JoinColumn(name = "pet_id"),
            inverseJoinColumns = @JoinColumn(name="pet_status_id"))
    @Setter
    @Getter
    private List<PetStatusValue> petAdoptionStatus;

    @Setter
    @Getter
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PetHealthRecordEntity> healthRecords;

    @Setter
    @Getter
    @NotBlank
    private int age;

    public PetEntity(String name,
                     int age,
                     List<PetSpeciesValue> petSpecies,
                     List<PetStatusValue> petStatus
    )  {
        this.name = name;
        this.age = age;
        this.petSpecies = petSpecies;
        this.petAdoptionStatus = petStatus;
    }

    public PetEntity(String name,
                     int age,
                     List<PetSpeciesValue> petSpecies
    )  {
        this.name = name;
        this.age = age;
        this.petSpecies = petSpecies;
    }


    public PetEntity() {
    }

}
