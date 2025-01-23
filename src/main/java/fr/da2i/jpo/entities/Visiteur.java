package fr.da2i.jpo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
public class Visiteur implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer vno;
	private String ip;
	private String nom;
	private String prenom;
	private String email;
	@ManyToOne
	@JoinColumn(name = "sigle")
	private Departement dept;
	@ManyToOne
	@JoinColumn(name = "lno")
	private Lycee lycee;

}
