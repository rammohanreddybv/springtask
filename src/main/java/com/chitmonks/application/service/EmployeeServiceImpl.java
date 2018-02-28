package com.chitmonks.application.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitmonks.application.entity.Employee;
import com.chitmonks.application.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {

		return employeeRepository.findAll();

	}

	@Override
	public void createEmployee(Employee emp) {
		String searchKeyArr[] = emp.getSearchkey().split(",");
		employeeRepository.save(emp);

	}

	@Override
	public void updateEmployee(Employee emp, int id) {

		employeeRepository.save(emp);

	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee getEmployeebyId(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> getBySearchkey(String searchkey) {

		List<Employee> ls = employeeRepository.findBySearchkeyIgnoreCaseContaining(searchkey);
		List<Employee> employeeList = new ArrayList<Employee>();
		for (Employee employee : ls) {
			List<String> searchkeys = Arrays.asList(employee.getSearchkey().split(","));
			if (searchkeys.contains(searchkey)) {
				employeeList.add(employee);
			}
		}

		return employeeList;

	}

}
