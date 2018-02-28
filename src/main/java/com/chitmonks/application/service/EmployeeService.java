package com.chitmonks.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chitmonks.application.entity.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public void createEmployee(Employee emp);
	void updateEmployee(Employee emp, int id);
	void deleteEmployee(int id);
	Employee getEmployeebyId(int id);
	List<Employee> getBySearchkey(String searchkey);

}
