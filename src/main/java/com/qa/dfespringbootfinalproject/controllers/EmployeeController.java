package com.qa.dfespringbootfinalproject.controllers;

import java.util.ArrayList;
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

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private List<Employee> staff = new ArrayList<>();
	
	
	@GetMapping("/hi")
	public String hi( ) {
		return "Good morning";
	}

	@PostMapping("/create")
	public Employee create(@RequestBody Employee staff) {
		this.staff.add(staff);
		return this.staff.get(this.staff.size() -1);	
	}
	
	@PutMapping("/update/{id}")
	public Employee update(@PathVariable int id, @RequestBody Employee staff) {
		
		this.staff.remove(id);
		
		this.staff.add(id, staff);
		
		return this.staff.get(id);	
	}
	
	@DeleteMapping("/delete/{id}")
	public Employee delete(@PathVariable int id) {
		return this.staff.remove(id);
		
	}
}
