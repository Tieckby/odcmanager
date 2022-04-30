package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.model.Activite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.backend.model.Exercice;
@RepositoryRestResource
@CrossOrigin("*")
public interface ExerciceRepository extends JpaRepository<Exercice, Long>{
	@Query(value="select Ex from Exercice Ex where Ex.annee = :annee AND Ex.etat = 'active'")
	Optional<Exercice> getExerciceByAnnee(String annee);

	@Query(value = "SELECT Ex FROM Exercice Ex WHERE Ex.etat = 'active' ")
	List<Exercice> getAllExercice();

	@Modifying
	@Transactional
	@Query(value = "UPDATE Exercice Ex SET Ex.etat = 'inactive'")
	public void updateExerciceByEtat(Long id);
	
	@Query(value="select Ex from Exercice Ex where Ex.id = :id AND Ex.etat = 'active'")
	Exercice findParId(Long id);

	@Query(value = "select u from Exercice u where u.annee = :annee")
	Optional<Exercice> findByAnnee(@Param("annee") String annee);



}
