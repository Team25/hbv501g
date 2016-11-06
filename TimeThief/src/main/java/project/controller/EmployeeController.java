package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Employee;
import project.service.EmployeeService;

@Controller
public class EmployeeController {
	
	// Instance Variables
    EmployeeService employeeService;

    // Dependency Injection
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @RequestMapping(value = "/employee/view/all", method = RequestMethod.GET)
    public String viewAllEmployees(HttpSession session, Model model){

        // The string "Login" that is returned here is the name of the view
        // (the Login.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Login" to something else, be sure you have a .jsp
        // file that has the same name
    	
    	Long empId = (Long)session.getAttribute("loggedInUser");
    	Employee currentEmployee = employeeService.findOne(empId);
    	String fullName = currentEmployee.getFullName();
    	if (currentEmployee.getIsAdmin()) {
    		// placeholder return -- TODO decide what to do
        	model.addAttribute("loginError", fullName + " is an admin");
    	}
    	else {
    		// placeholder return -- TODO decide what to do
    		model.addAttribute("loginError", fullName + " is not an admin");
    	}
    	return "login";
    }
}
