package project.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	public String login(String userName, String password) {

		System.out.println(userName + " :: " + password); 
		Employee employee = employeeService.verifyLogin(userName, password);
		
		String token;
		
		if(employee == null) token = null;
		else token = employeeService.createToken(employee);
		
		return token;
	}
	
	
	public boolean isValidToken(String token) {
		return employeeService.isValidToken(token);
	}
}
