package fr.da2i.jpo.repositories;

import fr.da2i.jpo.entities.Departement;
import org.springframework.data.repository.CrudRepository;

public interface DepartementRepository extends CrudRepository<Departement, String> {
}
