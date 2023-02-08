package com.api.userlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.userlist.entities.User;
import com.api.userlist.repositories.UserRepository;
import com.api.userlist.services.exceptions.EntityNotFoundException;
import com.api.userlist.services.exceptions.IllegalArgumentException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encotrado"));
	}
	
	public User save( User user) {
		return userRepository.save(user);
	}
	
	public void deleteById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Id não encotrado!"));
		
		userRepository.deleteById(user.getId());	
	}

}
