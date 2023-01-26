package com.api.userlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.userlist.entities.User;
import com.api.userlist.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		return userRepository.findById(id).get();
	}
	
	@PostMapping
	public User save(@RequestBody User user) {
		return userRepository.save(user);
	}
	
}
