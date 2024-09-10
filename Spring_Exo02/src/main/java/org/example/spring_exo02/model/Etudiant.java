package org.example.spring_exo02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Etudiant {
    private UUID id;
    private String name;
    private String surname;
    private int age;
    private String email;
}
