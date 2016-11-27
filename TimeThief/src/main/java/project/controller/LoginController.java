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
public class LoginController {
	
	// Instance Variables
    EmployeeService employeeService;

    // Dependency Injection
    @Autowired
    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpSession session){
    	
    	Long user = (Long)session.getAttribute("loggedInUser");
    	if(user == null){
    		return "login";
    	}
    	return "redirect:/clock";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String userId, @RequestParam String password,
    		Model model, HttpSession session){
    	
    	Employee employee = employeeService.verifyLogin(userId, password);
    	if(employee == null){
    		model.addAttribute("loginError", "Username or Password is incorrect.");
    		return "login";
    	}
    	
    	session.setAttribute("loggedInUser", employee.getId());
    	return "redirect:/clock";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session){
    	
    	session.removeAttribute("loggedInUser");
    	
    	return "redirect:/login";
    }
}


