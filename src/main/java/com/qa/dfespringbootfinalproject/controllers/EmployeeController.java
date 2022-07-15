package com.qa.dfespringbootfinalproject.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.dfespringbootfinalproject.entities.Employee;
import com.qa.dfespringbootfinalproject.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	
	@GetMapping("getAll")
	public List<Employee> getAll() {
		return this.service.getAll();
	}
	@GetMapping("getById/{id}")
	public Employee getById(@PathVariable Long id) {
		return this.service.getById(id);
		
	}

	@PostMapping("/create")
	public Employee create(@RequestBody Employee staff) {
		return this.service.create(staff);	
		
	}
	
	@PutMapping("/update/{id}")
	public Employee update(@PathVariable Long id, @RequestBody Employee staff) {
		return this.service.update(id, staff);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable Long id) {
		return this.service.delete(id);
			
	}
	
}


