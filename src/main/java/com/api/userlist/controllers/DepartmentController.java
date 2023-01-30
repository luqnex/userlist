package com.api.userlist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.userlist.entities.Department;
import com.api.userlist.repositories.DepartmentRepository;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping
	public List<Department> findAll() {
		return departmentRepository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Department findById(@PathVariable Long id) {
		return departmentRepository.findById(id).get();
	}
	
	@PostMapping
	public Department save(@RequestBody Department department) {
		return departmentRepository.save(department);
	}
	
}
