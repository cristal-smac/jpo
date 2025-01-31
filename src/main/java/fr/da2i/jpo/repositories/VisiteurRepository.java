package fr.da2i.jpo.repositories;

import fr.da2i.jpo.entities.Departement;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.da2i.jpo.entities.Visiteur;

public interface VisiteurRepository extends CrudRepository<Visiteur, Integer> {
	Visiteur findByEmailAndDept(String email, Departement dept);

	@Query(value = "SELECT v.dept.sigle AS dept, COUNT(v) AS cpt FROM Visiteur v GROUP BY v.dept.sigle")
	List<Map<String, Object>> getCountByDept();
}

