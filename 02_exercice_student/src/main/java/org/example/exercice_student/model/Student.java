package org.example.exercice_student.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message="Vous devez obligatoirement entrer un prénom !")
    private String firstname;

    @NotBlank(message="Vous devez obligatoirement entrer un nom !")
    private String lastname;

    @Min(value=12, message="Votre âge doit être compris entre 12 et 25 ans"  )
    @Max(value=25, message="Votre âge doit être inférieur à 25 ans")
    private int age;

    @NotBlank(message="Vous devez obligatoirement entrer une adresse mail !")
    @Email(message="Votre adresse mail doit être valide")
    private String email;
}
