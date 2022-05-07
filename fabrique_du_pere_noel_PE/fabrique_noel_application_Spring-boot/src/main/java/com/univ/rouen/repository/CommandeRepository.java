package com.univ.rouen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.CommandeEntity;

/**
 * Repository pour commande
 * @author GROUPE JEE
 */
@Repository
public interface CommandeRepository extends JpaRepository<CommandeEntity, Long>{

}
