package fr.da2i.jpo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaisieInput {
    @NotBlank
    private String prenom;

    @NotBlank
    private String nom;

	@Email
	@Pattern(regexp = ".+@.+\\..+", message = "Merci d'indiquer un email valide")    
    private String email;

    @NotBlank
    private String dept;

    @NotNull
    private Integer lycee;
}
