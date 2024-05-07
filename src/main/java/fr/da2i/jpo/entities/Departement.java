package fr.da2i.jpo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Departement {
    @Id
    private String sigle;
    private String libelle;
}
