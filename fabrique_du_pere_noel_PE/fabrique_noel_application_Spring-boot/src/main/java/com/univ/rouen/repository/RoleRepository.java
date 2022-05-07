package com.univ.rouen.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.rouen.entity.Role;

/**
 * Repository pour role
 * @author GROUPE JEE
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String roleName);
}
