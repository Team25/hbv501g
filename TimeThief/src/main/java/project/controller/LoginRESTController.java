package project.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.EmployeeMobile;
import client.shipping.EmptyJsonResponse;
import client.shipping.TokenInfo;
import project.persistence.entities.Employee;
import project.service.EmployeeService;
import project.service.EntryService;



@RestController
public class LoginRESTController {
	
	// Instance Variables
    EmployeeService employeeService;
    EntryService entryService;
    
    public LoginRESTController(EmployeeService employeeService, EntryService entryService) {
        this.employeeService = employeeService;
        this.entryService = entryService;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/applogin", produces = "application/json")
	public Object login(String userName, String password) {

		Employee employee = employeeService.verifyLogin(userName, password);
		
		if(employee == null) {
			return new ResponseEntity<Object>(new EmptyJsonResponse(), HttpStatus.OK);
		}
		
		String token = employeeService.createToken(employee);
		
		return new EmployeeMobile(employee.getFullName(),
									employee.getId(),
									employee.getPhoneNumber(),
									token);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/apptoken", produces = "application/json")
	public Object tokenLogin(String token) {
		EmployeeMobile employee = employeeService.isValidToken(token);
		System.out.println(token);

		if (employee == null) {
			return new ResponseEntity<Object>(new EmptyJsonResponse(), HttpStatus.OK);
		}
		
		return employee;
		
	}
}
