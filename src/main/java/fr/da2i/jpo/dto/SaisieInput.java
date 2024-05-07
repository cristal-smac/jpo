package fr.da2i.jpo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SaisieInput {
    private String prenom;
    private String nom;
    private String email;
    private String dept;
    private int lycee;
}
