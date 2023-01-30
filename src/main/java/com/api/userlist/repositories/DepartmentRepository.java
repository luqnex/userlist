package com.api.userlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.userlist.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
