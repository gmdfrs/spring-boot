package com.univ.rouen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.univ.rouen.entity.LutinEntity;

/**
 * Repository pour Lutin
 * @author GROUPE JEE
 */
@Repository
public interface  LutinRepository extends JpaRepository<LutinEntity,Long>{
}
