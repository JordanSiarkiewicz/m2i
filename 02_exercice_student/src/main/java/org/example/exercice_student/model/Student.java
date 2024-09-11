package org.example.exercice_student.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Long id;
    @NotNull(message="Vous devez obligatoirement entrer un prénom !")
    @NotBlank
    private String firstname;
    @NotNull(message="Vous devez obligatoirement entrer un nom !")
    @NotBlank
    private String lastname;
    @Min(value=12, message="Votre âge doit être compris entre 12 et 25"  )
    @Max(25)
    private int age;
    @NotNull(message="Vous devez obligatoirement entrer une adresse mail !")
    @NotBlank
    @Email
    private String email;
}
