package com.patasamigas.webapi.adapter.persistance.entities;

import com.patasamigas.webapi.adapter.persistance.objectValues.VeterinarianInfoValue;
import com.patasamigas.webapi.domain.objectValues.VeterinarianInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Entity(name = "VaccineRecord")
@Table(name = "vaccine_record",
        uniqueConstraints = {
        @UniqueConstraint(columnNames = "id")} )
public class VaccineRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pet_health_record_id")
    private PetHealthRecordEntity petHealthRecord;

    @Size(min = 3, max = 20)
    private String vaccineType;

    private LocalDate vaccineDate;

    private LocalDate nextDueDate;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "name", column = @Column(name = "veterinarian_name")),
            @AttributeOverride(name = "clinic", column = @Column(name = "clinic")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "veterinarian_phone_number"))
    })
    private VeterinarianInfoValue veterinarianInfo;

}
