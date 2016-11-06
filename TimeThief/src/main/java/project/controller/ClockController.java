package project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Employee;
import project.persistence.entities.Entry;
import project.service.EmployeeService;
import project.service.EntryService;

@Controller
public class ClockController {
	
	// Instance Variables
    EmployeeService employeeService;
    EntryService entryService;

    // Dependency Injection
    @Autowired
    public ClockController(EmployeeService employeeService, EntryService entryService) {
        this.employeeService = employeeService;
        this.entryService = entryService;
    }

    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080/login" into a browser, this
    // method is called
    @RequestMapping(value = "/clock", method = RequestMethod.GET)
    public String loginPage(HttpSession session, Model model){
    	
    	// Check if user is signed in:
    	Long user = (Long)session.getAttribute("loggedInUser");
    	if(user==null)
    		return "redirect:/login";
    	model.addAttribute("clockInInfo", "Welcome");
    	model.addAttribute("user", user.toString());
    	// see if user is clocked in
    	Entry entry = entryService.isEmployeeLoggedIn(user);
    	if(entry == null){
    		model.addAttribute("clockStatus", "Clock In!");
    	} else{
    		model.addAttribute("clockStatus", "Clock Out!");
    	}

    	
        return "clock";
    }

    @RequestMapping(value = "/clock", method = RequestMethod.POST)
    public String login(@RequestParam String userId, @RequestParam String password,
    		Model model, HttpSession session){
    	
    	return "clock";
    }
}