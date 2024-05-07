package fr.da2i.jpo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Lycee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lno;
	private String codepostal;
	private String commune;
	private String nom;
    /*
	@OneToMany(mappedBy="lycee")
	private List<Visiteur> visiteurs;
    */
}
