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

    	
    	String userName = employeeService.findOne(userId).getFullName();
    	model.addAttribute("user", "Welcome "+userName);
    	// see if user is clocked in
    	
    	Entry entry = entryService.isEmployeeClockedIn(userId);
    	if(entry == null){
    		model.addAttribute("clockStatus", "Clock In!");
    		model.addAttribute("clockInInfo", "<div style='background-color:yellow'><p>You are currently not clocked in</p></div>");
    		
    		String select = "<label for='department'>Department:</label>"
    				+ "<select form='clock-form' name='department' id='department'>"
    				+ "<option value='Overlord'>Overlord</option>"
    				+ "<option value='BigBossDepartment'>BigBossDepartment</option>"
    				+ "<option value='JokerDepartment'>JokerDepartment</option>"
    				+ "<option value='BatmanDepartment'>BatmanDepartment</option>"
    				+ "</select>";
    		
    		model.addAttribute("departmentChooser", select);
    	} else{
    		model.addAttribute("clockStatus", "Clock Out!");
    		model.addAttribute("clockInInfo", "<div style='background-color:#58D68D'><p>You are currently clocked in to " + entry.getDepartment() + "</p></div>");
    	}

    	if (currentEmployee.isAdmin()) 
    		model.addAttribute("adminToolbar", "<a href='employee/view/all'><div>Employee list</div></a>");
    	
        return "clock";
    }

    @RequestMapping(value = "/clock", method = RequestMethod.POST)
    public String login(@RequestParam(required = false) String department, Model model, HttpSession session){
    	
    	// Check if user is signed in:
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";

    	Employee currentEmployee = employeeService.findOne(userId);

    	String userName = employeeService.findOne(userId).getFullName();
    	model.addAttribute("user", "Welcome "+userName);
    	
    	// TODO laga
    	if(department == null){
    		Entry currentEntry = entryService.isEmployeeClockedIn(userId);
    		department = currentEntry.getDepartment();
    	}
    	
    	Entry entry = entryService.clock(userId, department);
    	
    	if(entry.getOutTime() == null){
    	 	model.addAttribute("loginFeedback", "clock in successful");
    	 	model.addAttribute("clockStatus", "Clock Out!");
    		model.addAttribute("clockInInfo", "<div style='background-color:#58D68D'><p>You are currently clocked in to " + entry.getDepartment() + "</p></div>");
    	} else{
    		model.addAttribute("loginFeedback", "clock out successful");
    		model.addAttribute("clockStatus", "Clock In!");
    		model.addAttribute("clockInInfo", "<div style='background-color:yellow'><p>You are currently not clocked in</p></div>");
    		
    		String select = "<label for='department'>Department:</label>"
    				+ "<select form='clock-form' name='department' id='department'>"
    				+ "<option value='Overlord' selected>Overlord</option>"
    				+ "<option value='BigBossDepartment'>BigBossDepartment</option>"
    				+ "<option value='JokerDepartment'>JokerDepartment</option>"
    				+ "<option value='BatmanDepartment'>BatmanDepartment</option>"
    				+ "</select>";
    		
    		model.addAttribute("departmentChooser", select);
    	}

    	if (currentEmployee.isAdmin()) 
    		model.addAttribute("adminToolbar", "<a href='employee/view/all'>See Employee List</a>");

    	return "clock";
    }
}