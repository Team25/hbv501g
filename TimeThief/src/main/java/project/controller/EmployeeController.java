package project.controller;

import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	Employee currentEmployee = employeeService.findOne(userId);
    	String fullName = currentEmployee.getFullName();
    	if (currentEmployee.isAdmin()) {
    		List<Employee> employeeList = employeeService.findAll();
    		// placeholder list till we figure out how we want to represent this data
    		ArrayList<String> employeeNames = new ArrayList<String>();
    		for (ListIterator<Employee> iter = employeeList.listIterator(); iter.hasNext(); ) {
    		    Employee e = iter.next();
    		    String empString = e.getFullName();
    		    empString += " - " + e.getSocialSecurity();
    		    empString += " - " + e.getHomeAddress();
    		    empString += " - " + e.getPhoneNumber();
    		    empString += " - Admin:" + e.isAdmin();
    		    employeeNames.add(empString);
    		}
        	model.addAttribute("employeeList", employeeNames);
    	}
    	else {
    		// placeholder message till we figure out what to do
    		model.addAttribute("employeeList", fullName + " is not an admin. Cannot display list.");
    	}
    	return "employeeList";
    }
    
    @RequestMapping(value = "/employee/create", method = RequestMethod.GET)
    public String createEmployeeGet(HttpSession session, Model model){
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	
    	if (currentEmployee.isAdmin()) {
    		model.addAttribute("employee", new Employee());
    		return "createEmployee";
    	}
    	
    	// TODO: redirect to "unauthorized" site or something else
    	return "redirect:/login";
    }
    
    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public String createEmployeePost(@ModelAttribute("employee") Employee employee, 
    									HttpSession session, 
    									Model model){
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	
    	if (currentEmployee.isAdmin()) {
    		Employee newEmployee = employeeService.save(employee);
    		return "createEmployee";
    	}
    	
    	// TODO: redirect to "unauthorized" site or something else
    	return "redirect:/login";
    }
}
