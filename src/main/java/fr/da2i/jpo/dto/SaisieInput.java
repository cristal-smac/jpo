package fr.da2i.jpo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SaisieInput {
    @NotBlank(message="Champ prénom obligatoire")
    private String prenom;

    @NotBlank(message="Champ nom obligatoire")
    private String nom;

    @NotBlank(message="Champ email obligatoire")
    private String email;

    @NotBlank(message="Champ dept obligatoire")
    private String dept;

    private int lycee;
}
