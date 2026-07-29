package com.example.bookshowroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshowroom.model.User;
import com.example.bookshowroom.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> searchUser(String id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User addNewUser(User newUser) {
		// TODO Auto-generated method stub
		return userRepo.save(newUser);
	}

	@Override
	public void deleteUser(String id) {
		// TODO Auto-generated method stub
		userRepo.deleteById(id);
		
	}

	@Override
	public List<User> getUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public List<User> getUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public Optional<User> login(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameAndPassword(username, password);
	}
}
