package com.univ.rouen.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.univ.rouen.entity.UserEntity;

/**
 * Repository pour user
 * @author GROUPE JEE
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
	UserEntity findByEmail(@Param("email") String mail);
}
