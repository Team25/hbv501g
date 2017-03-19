package project.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.EmployeeMobile;
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
	public EmployeeMobile login(String userName, String password) {

		Employee employee = employeeService.verifyLogin(userName, password);
		
		if(employee == null) return null;
		
		return new EmployeeMobile(employee.getFullName(),
									employee.getId(),
									employee.getPhoneNumber(),
									employee.getToken());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/apptoken", produces = "application/json")
	public EmployeeMobile isValidToken(String token) {
		
		return employeeService.isValidToken(token);
	}
}
