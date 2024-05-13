package fr.da2i.jpo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SaisieInput {
    @NotBlank
    private String prenom;
    @NotBlank
    private String nom;
    @Email
    private String email;
    @NotBlank
    private String dept;
    @NotNull
    private Integer lycee;
}
