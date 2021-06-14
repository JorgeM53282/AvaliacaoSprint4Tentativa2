package com.Avaliacao4.AvaliacaoSprint4.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Avaliacao4.AvaliacaoSprint4.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByEmail(String username);

}
