package fr.da2i.jpo.repositories;

import org.springframework.data.repository.CrudRepository;

import fr.da2i.jpo.entities.Visiteur;

public interface VisiteurRepository extends CrudRepository<Visiteur, Integer> {
	Visiteur findByEmailAndDept(String email, String dept);
}
