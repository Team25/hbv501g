package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.EmployeeMobile;

import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Employee;

import project.service.EmployeeService;
import project.service.MessageService;


@RestController
public class EmployeeRESTController {
	
	EmployeeService employeeService;
	MessageService messageService;
	
	public EmployeeRESTController(MessageService messageService, EmployeeService employeeService) {
		this.messageService = messageService;
		this.employeeService = employeeService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appemployeelist", produces = "application/json")
	public ArrayList<EmployeeMobile> getEmployeeList(String token){
		
		//TODO check if token is valid
		
		List<Employee> employees = employeeService.findAll();
		ArrayList<EmployeeMobile> mobileEmployees = new ArrayList<EmployeeMobile>();
		for(Employee e: employees){
			EmployeeMobile mobileEmployee = new EmployeeMobile(e);
			mobileEmployees.add(mobileEmployee);
		}
		
		return mobileEmployees;
	}
	
	// TODO put in rest of methods for this controller.

}
