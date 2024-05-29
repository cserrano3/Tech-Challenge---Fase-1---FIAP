package com.patasamigas.webapi.adapter.persistance.objectValues;

import com.patasamigas.webapi.domain.objectValues.ERole;
import com.patasamigas.webapi.domain.objectValues.PetSpecies;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "species")
public class PetSpeciesValue{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private PetSpecies name;

    public PetSpeciesValue() {

    }

    public PetSpeciesValue(PetSpecies name) {
        this.name = name;
    }

}
