package com.digitalbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbook.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByAuthorname(String username);

	Boolean existsByAuthorname(String username);

	Boolean existsByEmail(String email);
}
