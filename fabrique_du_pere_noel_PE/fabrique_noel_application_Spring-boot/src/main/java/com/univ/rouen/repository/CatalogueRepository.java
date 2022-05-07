package com.univ.rouen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.CatalogueEntity;

/**
 * Repository pour catalogue
 * @author GROUPE JEE
 */
@Repository
public interface CatalogueRepository extends JpaRepository<CatalogueEntity, Long> {

}
