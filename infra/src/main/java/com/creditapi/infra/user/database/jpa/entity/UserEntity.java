package com.creditapi.infra.user.database.jpa.entity;

import com.creditapi.domain.user.model.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Getter
@Setter
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identityNumber;

    private String firstName;

    private String lastName;

    @CreationTimestamp
    private Instant createdDate;

    @UpdateTimestamp
    private Instant updatedDate;

    public User toDomain() {
        return User.builder()
                .id(id)
                .identityNumber(identityNumber)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
