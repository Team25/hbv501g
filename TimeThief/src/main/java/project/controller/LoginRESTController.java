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
	public String login(@RequestParam(value="username") String userName, @RequestParam(value="password") String password) {
		Employee employee = employeeService.verifyLogin(userName, password);
		if(employee == null){
    		return "fail";
    	}
		return "success";
	}
}
