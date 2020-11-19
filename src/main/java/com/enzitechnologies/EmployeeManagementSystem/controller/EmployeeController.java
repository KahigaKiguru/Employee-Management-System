package com.enzitechnologies.EmployeeManagementSystem.controller;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.enzitechnologies.EmployeeManagementSystem.model.Employee;
import com.enzitechnologies.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/")
	public String getAllEmployees(Model model) {
		Iterable<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add_employee";
	}
	@PostMapping("/addNewEmployee")
	public String addNewEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.addEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable(value = "id") int id, Model model) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		
			model.addAttribute("employee", employee);
			
			return "update_employee";		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/";
	}
}
