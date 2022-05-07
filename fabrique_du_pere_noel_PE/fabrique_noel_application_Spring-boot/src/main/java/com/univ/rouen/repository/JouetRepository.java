package com.univ.rouen.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.JouetEntity;;

/**
 * Repository pour jouet
 * @author GROUPE JEE
 */
@Repository
public interface JouetRepository extends JpaRepository<JouetEntity,Long>{

	JouetEntity findByNom(@Param("nom") String nom);
	
	Optional<JouetEntity> findById(@Param("id") Long id);
}
