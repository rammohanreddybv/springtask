package com.chitmonks.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitmonks.application.entity.Employee;
import com.chitmonks.application.service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		
		return employeeService.getAllEmployees();		
	}
	
	@GetMapping("/id/{id}")
	public Employee getEmployeebyId(@PathVariable(value="id") Integer id) {
		return employeeService.getEmployeebyId(id);
		
	}
	
	@PostMapping("/add")
	public void insertEmployee(@RequestBody Employee employee) {
		
		
		employeeService.createEmployee(employee);
		
	}
	
	@PutMapping("/update/{id}")
	public void updateEmployee(@RequestBody Employee employee,@PathVariable(value="id") Integer id) {
		employeeService.updateEmployee(employee, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable(value="id") Integer id) {
		employeeService.deleteEmployee(id);
		
	}
	
	@GetMapping("/search/{key}")
	public List<Employee> getEmployeebySearchkey(@PathVariable(value="key") String key){
		
		return employeeService.getBySearchkey(key);
		
	}

}
