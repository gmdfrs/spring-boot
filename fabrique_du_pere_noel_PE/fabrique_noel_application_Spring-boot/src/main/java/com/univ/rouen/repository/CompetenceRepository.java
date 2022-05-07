package com.univ.rouen.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.*;

/**
 * Repository pour competence
 * @author GROUPE JEE
 */
@Repository
public interface CompetenceRepository extends JpaRepository<CompetenceEntity,Long>{
}
