package com.qa.dfespringbootfinalproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.qa.dfespringbootfinalproject.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
}

