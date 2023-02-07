package com.api.userlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.api.userlist.entities.User;
import com.api.userlist.exceptionHandler.NotFoundException;
import com.api.userlist.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException());
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public ResponseEntity<Object> delete(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.notFound().build();
	}

}
