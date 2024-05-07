package fr.da2i.jpo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Departement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String sigle;
    private String libelle;
}
