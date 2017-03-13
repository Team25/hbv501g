package project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.persistence.entities.Employee;
import project.service.EmployeeService;



@RestController
public class LoginRESTController {
	
	// Instance Variables
    EmployeeService employeeService;
    
    public LoginRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/applogin")
	public String login(String userName, String password) {
		Employee employee = employeeService.verifyLogin(userName, password);
		
		if(employee == null) return null;
		else return employeeService.createToken(employee);
	}
	
	
	public boolean isValidToken(String token) {
		return employeeService.isValidToken(token);
	}
}
