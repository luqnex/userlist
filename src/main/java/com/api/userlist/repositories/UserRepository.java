package com.api.userlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.userlist.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
