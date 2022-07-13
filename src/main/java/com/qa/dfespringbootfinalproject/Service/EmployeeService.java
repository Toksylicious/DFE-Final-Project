package com.qa.dfespringbootfinalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.dfespringbootfinalproject.entities.Employee;

@Service
public class EmployeeService {
	
	private List<Employee> staff = new ArrayList<>();
	
	public List<Employee> getAll() {
		return  this.staff;
	}
	
	public Employee getById(int id) {
		return this.staff.get(id);
	}
	public Employee create(Employee staff) {
		this.staff.add(staff);
		return this.staff.get(this.staff.size() -1);
	}
	public Employee update(int id,Employee staff) {
		this.staff.remove(id);
		
		this.staff.add(id, staff);
		
		return this.staff.get(id);
		
	}
	public Employee delete(int id) {
		return this.staff.remove(id);
	}
		
}


