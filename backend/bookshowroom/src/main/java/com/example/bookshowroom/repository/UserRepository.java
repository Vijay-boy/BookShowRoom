package com.example.bookshowroom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshowroom.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	List<User> findByEmail(String email);
	
	List<User> findByEmailAndPassword(String email, String password);
	
	Optional<User> findByUsernameAndPassword(String username, String password);

}
