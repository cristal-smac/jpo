package fr.da2i.jpo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.da2i.jpo.entities.Lycee;

public interface LyceeRepository extends CrudRepository<Lycee, Integer> {
	List<Lycee> findAllByOrderByCommune();
}
