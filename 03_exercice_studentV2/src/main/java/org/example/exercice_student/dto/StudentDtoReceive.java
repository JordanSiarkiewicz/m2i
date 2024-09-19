package org.example.exercice_student.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoReceive {
    @NotBlank(message = "Le champ ne doit pas être vide !")
    private String firstname;
    @NotBlank(message = "Le champ ne doit pas être vide !")
    private String lastname;
    @Min(16)
    @Max(50)
    private int age;
    @NotBlank(message = "Le champ ne doit pas être vide !")
    @Email
    private String email;
    private String photo;
}
