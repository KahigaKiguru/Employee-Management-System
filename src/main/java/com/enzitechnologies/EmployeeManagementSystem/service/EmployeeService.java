package com.enzitechnologies.EmployeeManagementSystem.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.enzitechnologies.EmployeeManagementSystem.model.Employee;
import com.enzitechnologies.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
//	Retrieve all employees
	public Iterable<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
//	Add an employee
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
//	Update an Employee
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
//	Find Employee ById
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
//	Delete an Employee
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}
}
