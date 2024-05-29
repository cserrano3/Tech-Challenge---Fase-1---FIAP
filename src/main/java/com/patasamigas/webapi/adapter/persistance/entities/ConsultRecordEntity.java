package com.patasamigas.webapi.adapter.persistance.entities;

import com.patasamigas.webapi.adapter.persistance.objectValues.VeterinarianInfoValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
@Entity(name = "ConsultRecord")
@Table(name = "consult_record",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")} )
public class ConsultRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pet_health_record_id")
    private PetHealthRecordEntity petHealthRecord;

    private LocalDate consultDate;

    private LocalDate nextConsultDate;
    
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "name", column = @Column(name = "veterinarian_name")),
            @AttributeOverride(name = "clinic", column = @Column(name = "clinic")),
            @AttributeOverride(name = "phoneNumber", column = @Column(name = "veterinarian_phone_number"))
    })
    private VeterinarianInfoValue veterinarianInfo;


    @Size(max = 200)
    private String reasonForVisit;

    @Size(max = 200)
    private String Diagnoses;

    @Size(max = 200)
    private String medicationsPrescribed;

}
