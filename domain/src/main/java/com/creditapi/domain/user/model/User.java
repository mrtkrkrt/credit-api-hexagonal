package com.creditapi.domain.user.model;

import lombok.*;

@Data
@Builder
@ToString
@With
@EqualsAndHashCode
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String identityNumber;

}
