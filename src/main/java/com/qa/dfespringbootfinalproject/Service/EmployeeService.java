package com.qa.dfespringbootfinalproject.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringbootfinalproject.entities.Employee;
import com.qa.dfespringbootfinalproject.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	private EmployeeRepo repo;
	
	public EmployeeService(EmployeeRepo repo) {
		this.repo = repo;
	}
	
	public List<Employee> getAll() {
		return  this.repo.findAll();
	}
	
	public Employee getById(Long id) {
		return this.repo.findById(id).get();
		
	}
	public Employee create(Employee staff) {
		return this.repo.saveAndFlush(staff);
		
	}
	public Employee update(Long id,Employee staff) {
		Employee existing = repo.findById(id).get();
		
		existing.setFirstName(staff.getFirstName());
		existing.setLastName(staff.getLastName());
		existing.setEmail(staff.getEmail());
		existing.setDepartment(staff.getDepartment());
		existing.setAddress(staff.getAddress());
		
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
			
		
	}
}
		
		

	