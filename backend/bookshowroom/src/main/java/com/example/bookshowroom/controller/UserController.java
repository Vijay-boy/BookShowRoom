package com.example.bookshowroom.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookshowroom.dto.LoginDto;
import com.example.bookshowroom.model.User;
import com.example.bookshowroom.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/api/users")
	public List<User> apiForGetUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/api/users/{id}")
	public Optional<User> apiForSearchUser(@PathVariable String id)
	{
		Optional<User> opt=userService.searchUser(id);
		if(opt.isEmpty())
			return Optional.ofNullable(new User());
		
		return opt;
	}
	
	@GetMapping("/api/users/filter")
	public List<User> apiForUserByEmail(@RequestParam String email)
	{
		return userService.getUsersByEmail(email);
	}
	
	@GetMapping("/api/users/user-filter")
	public List<User> apiForUserByEmailAndPassword(@RequestParam String email, String password)
	{
		return userService.getUserByEmailAndPassword(email, password);
	}
	
	@PostMapping("/api/users")
	public User apiForAddUser(@RequestBody User user)
	{
		Optional<User> opt=userService.searchUser(user.getUsername());
		if(opt.isEmpty())
			return userService.addNewUser(user);
		
		return new User();
	}
	
	@PostMapping("/api/users/login")
	public Optional<User> apiForLogin(@RequestBody LoginDto loginData)
	{
		return userService.login(loginData.getUsername(), loginData.getPassword());
	}
	
	@PutMapping("api/users/{id}")
	public User apiForEditUser(@PathVariable String id, @RequestBody User user)
	{
		Optional<User> opt=userService.searchUser(id);
		if(opt.isPresent())
			return userService.addNewUser(user);
		
		return new User();
	}
	
	@DeleteMapping("/api/users/{id}")
	public Optional<User> apiForDeleteUser(@PathVariable String id)
	{
		Optional<User> opt=userService.searchUser(id);
		if(opt.isPresent())
		{
			userService.deleteUser(id);
			return opt;
		}
		return opt;
	}
}
