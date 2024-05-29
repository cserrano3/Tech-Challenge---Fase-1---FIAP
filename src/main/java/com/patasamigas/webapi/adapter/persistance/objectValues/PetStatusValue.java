package com.patasamigas.webapi.adapter.persistance.objectValues;

import com.patasamigas.webapi.domain.objectValues.PetSpecies;
import com.patasamigas.webapi.domain.objectValues.PetStatus;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "adoption_statuses")
public class PetStatusValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PetStatus name;

    public PetStatusValue() {

    }

    public PetStatusValue(PetStatus name) {
        this.name = name;
    }


}
