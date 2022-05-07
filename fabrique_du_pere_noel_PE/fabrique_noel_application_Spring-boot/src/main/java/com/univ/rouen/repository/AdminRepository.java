package com.univ.rouen.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.AdminEntity;

/**
 * Repository pour Admin
 * @author GROUPE JEE
 */

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long>{
}
