package net.springboot.homework.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.springboot.homework.entities.User;


public interface UserRepository extends JpaRepository<User, Integer>
{

	Optional<User> findByEmail(String email);

}
