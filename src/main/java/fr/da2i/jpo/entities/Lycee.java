package fr.da2i.jpo.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Lycee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lno;
	@NotBlank
	private String codepostal;
	@NotBlank
	private String commune;
	@NotBlank
	@Length(min = 5, max = 5)
	private String nom;
	/*
	 * @OneToMany(mappedBy="lycee")
	 * private List<Visiteur> visiteurs;
	 */
}
