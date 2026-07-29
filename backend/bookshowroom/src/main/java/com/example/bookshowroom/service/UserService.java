package com.example.bookshowroom.service;

import java.util.List;
import java.util.Optional;

import com.example.bookshowroom.model.User;

public interface UserService {

	List<User> getAllUsers();
	
	Optional<User> searchUser(String id);
	
	User addNewUser(User newUser);
	
	void deleteUser(String id);
	
	List<User> getUsersByEmail(String email);
	
	List<User> getUserByEmailAndPassword(String email, String password);
	
	Optional<User> login(String username, String password);
}
