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
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";

    	Employee currentEmployee = employeeService.findOne(userId);

    	
    	
    	model.addAttribute("user", "Welcome "+userId.toString());
    	// see if user is clocked in
    	
    	Entry entry = entryService.isEmployeeClockedIn(userId);
    	if(entry == null){
    		model.addAttribute("clockStatus", "Clock In!");
    		model.addAttribute("clockInInfo", "You are not logged in");
    	} else{
    		model.addAttribute("clockStatus", "Clock Out!");
    		model.addAttribute("clockInInfo", "You are logged in");
    	}

    	if (currentEmployee.isAdmin()) 
    		model.addAttribute("adminToolbar", "<a href='employee/view/all'>Employee list</a>");
    	
        return "clock";
    }

    @RequestMapping(value = "/clock", method = RequestMethod.POST)
    public String login(@RequestParam String department, Model model, HttpSession session){
    	
    	// Check if user is signed in:
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";

    	Employee currentEmployee = employeeService.findOne(userId);

    	
    	model.addAttribute("user", "Welcome "+userId.toString());
    	
    	Entry entry = entryService.clock(userId, department);
    	
    	if(entry.getOutTime() == null){
    	 	model.addAttribute("loginFeedback", "clock in successful");
    	 	model.addAttribute("clockStatus", "Clock Out!");
    		model.addAttribute("clockInInfo", "You are logged in");
    	} else{
    		model.addAttribute("loginFeedback", "clock out successful");
    		model.addAttribute("clockStatus", "Clock In!");
    		model.addAttribute("clockInInfo", "You are not logged in");
    	}

    	if (currentEmployee.isAdmin()) 
    		model.addAttribute("adminToolbar", "<a href='employee/view/all'>Employee list</a>");

    	return "clock";
    }
}