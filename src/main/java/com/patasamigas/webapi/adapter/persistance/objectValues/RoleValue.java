package com.patasamigas.webapi.adapter.persistance.objectValues;

import com.patasamigas.webapi.domain.objectValues.ERole;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "roles")
public class RoleValue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public RoleValue(ERole name) {
        this.name = name;
    }

    public RoleValue() {

    }
}