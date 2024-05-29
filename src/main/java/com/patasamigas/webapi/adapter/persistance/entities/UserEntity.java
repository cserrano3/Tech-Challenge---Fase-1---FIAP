package com.patasamigas.webapi.adapter.persistance.entities;

import com.patasamigas.webapi.adapter.persistance.objectValues.AddressValue;
import com.patasamigas.webapi.adapter.persistance.objectValues.RoleValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor

@Entity(name = "User")
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "CPF") })

public class UserEntity {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    @Getter
    @Setter
    @Size(min = 10, max = 30)
    private String email;

    @NotBlank
    @Size(min = 3, max = 20)
    @Getter
    private String name;

    @NotBlank
    @Size(min = 2, max = 40)
    @Getter
    private String lastName;

    @NotBlank
    @CPF(message = "Invalid CPF")
    @Getter
    private String CPF;

    @NotBlank
    @Setter
    @Size(min = 8, max = 70)
    @Getter
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    @Getter
    @Setter
    private List<RoleValue> roles;

    @Getter
    @Setter
    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "number", column = @Column(name = "house_number")),
            @AttributeOverride(name = "street", column = @Column(name = "street")),
            @AttributeOverride(name = "zip", column = @Column(name = "zip_code"))
    })
    private AddressValue address;


    public UserEntity(String email, String name, String lastName, String CPF, List<RoleValue> roles, AddressValue address, String password) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.CPF = CPF;
        this.roles = roles;
        this.address = address;
        this.password = password;
    }

}
