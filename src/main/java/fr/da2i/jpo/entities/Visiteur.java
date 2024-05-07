package fr.da2i.jpo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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
    private String dept;
	@ManyToOne
	@JoinColumn(name="lno")
	private Lycee lycee;
	
}
