package fr.da2i.jpo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.da2i.jpo.entities.Lycee;

public interface LyceeRepository extends CrudRepository<Lycee, Integer> {
	public Lycee findByLno(Integer id);
	public Lycee findByNomAndCodepostal(String nom,String codepostal);
	public List<Lycee> findAllByOrderByCommune();

}
