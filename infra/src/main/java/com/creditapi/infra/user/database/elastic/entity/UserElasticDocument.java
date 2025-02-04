package com.creditapi.infra.user.database.elastic.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "users")
public class UserElasticDocument {

    private Long identityNumber;
    private String firstName;
    private String lastName;
}
