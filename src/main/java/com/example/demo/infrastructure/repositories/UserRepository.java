package com.example.demo.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.models.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

	@Query("""
			SELECT u from User u
			WHERE u.email = :email
			""")
	User findByEmail(@Param("email") String email);

	@Query("""
			SELECT u from User u
			WHERE u.email = :email
			AND u.password = :password
			""")
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
