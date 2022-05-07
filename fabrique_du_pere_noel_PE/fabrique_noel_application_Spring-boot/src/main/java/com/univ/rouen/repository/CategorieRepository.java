package com.univ.rouen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.CategorieEntity;

/**
 * Repository pour categorie
 * @author GROUPE JEE
 */
@Repository
public interface CategorieRepository extends JpaRepository<CategorieEntity, Long> {

}
