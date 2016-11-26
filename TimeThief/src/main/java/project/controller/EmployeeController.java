package project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String viewAllEmployees(HttpSession session, Model model, @RequestParam(value="findEmployee", required=false, defaultValue="") String searchString) {
        // The string "Login" that is returned here is the name of the view
        // (the Login.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        // If you change "Login" to something else, be sure you have a .jsp
        // file that has the same name
    	
    	if(!searchString.isEmpty()){
    		String buttonHtml = "<a href=\"/employee/view/all\"><button>Reset</button></a>";
    		model.addAttribute("resetButton", buttonHtml);
    	}
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	Employee currentEmployee = employeeService.findOne(userId);
    	
    	String fullName = currentEmployee.getFullName();
    	List<Employee> employeeList;
    	if (currentEmployee.getIsAdmin()) {
        	if (!searchString.isEmpty()) {
        		employeeList = employeeService.findByLoginNameOrFullName(searchString);
        		model.addAttribute("searchString", searchString);
        	} else { 
        		employeeList = employeeService.findAll();
        	}
    		model.addAttribute("employeeList", employeeList);
    		model.addAttribute("adminToolbar", "true");
    	}
    	else {
    		// placeholder message till we figure out what to do
    		model.addAttribute("employeeList", fullName + " is not an admin. Cannot display list.");
    	}
    	return "employeeList";
    }
    
    @RequestMapping(value = "/employee/view/{employeeId}", method = RequestMethod.GET)
    public String viewEmployeeById(@PathVariable Long employeeId, HttpSession session, Model model){
    	
    	Long currentUserId = (Long)session.getAttribute("loggedInUser");
    	if(currentUserId==null)
    		return "redirect:/login";
    	Employee currentEmployee = employeeService.findOne(currentUserId);
    	Employee selectedEmployee = employeeService.findOne(employeeId);
    	if (currentEmployee.getIsAdmin() || currentUserId == employeeId) {
    		model.addAttribute("employee", selectedEmployee);
    		model.addAttribute("adminToolbar", "true");    		
    		return "employee";
    	}
    	
       	return "unauthorized";
    }
    
    @RequestMapping(value = "/employee/update/{employeeId}", method = RequestMethod.GET)
    public String updateEmployeeGet(@PathVariable Long employeeId, HttpSession session, Model model){
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	Employee currentEmployee = employeeService.findOne(userId);
    	Employee selectedEmployee = employeeService.findOne(employeeId);
    	if (currentEmployee.getIsAdmin()) {
    		model.addAttribute("employee", new Employee());
    		model.addAttribute("employeeToUpdate", selectedEmployee);
    		model.addAttribute("employeeId", selectedEmployee.getId().toString());
    		model.addAttribute("adminToolbar", "true");
    		return "updateEmployee";
    	} else if(userId == employeeId){
    		model.addAttribute("employee", new Employee());
    		model.addAttribute("restrictions", "readonly");
    		model.addAttribute("hidden", "hidden");
    		model.addAttribute("employeeToUpdate", currentEmployee);
    		model.addAttribute("employeeId", selectedEmployee.getId().toString());
    		return "updateEmployee";
    	}
    	
       	return "unauthorized";
    }
    
    @RequestMapping(value = "/employee/update/{employeeId}", method = RequestMethod.POST)
    public String updateEmployeePost(@PathVariable Long employeeId, @Valid @ModelAttribute("employee") Employee employee, 
			BindingResult result,
			HttpSession session, 
			Model model){
    	Long userId = (Long)session.getAttribute("loggedInUser");

    	if(userId==null)
    		return "redirect:/login";
	
    	Employee currentEmployee = employeeService.findOne(userId);
    	Employee selectedEmployee = employeeService.findOne(employeeId);
    	
    	if (currentEmployee.getIsAdmin() || employeeId.equals(userId)) {
    		if(currentEmployee.getIsAdmin()) model.addAttribute("adminToolbar", "true");
    		model.addAttribute("employeeToUpdate", selectedEmployee);
    		
    		if(result.hasErrors()){
    			model.addAttribute("updateMessage", result.getFieldError().getField() + " contains some error");
    			return "updateEmployee";
    		}
    		else{
    			Employee newEmployee = employeeService.save(employee);
    			if(newEmployee==null)
    				model.addAttribute("updateMessage", "Updating employee to DB failed.");
    			else
    				model.addAttribute("updateMessage", "Updating employee Successful.");
    			return "updateEmployee";
    		}
    	}
	
    	return "unauthorized";
	}
    
    
    @RequestMapping(value = "/employee/create", method = RequestMethod.GET)
    public String createEmployeeGet(HttpSession session, Model model){
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	
    	if (currentEmployee.getIsAdmin()) {
    		Employee formEmployee = new Employee();
    		//formEmployee = employeeService.save(formEmployee);
    		model.addAttribute("employee", formEmployee);
    		model.addAttribute("adminToolbar", "true");
    		return "createEmployee";
    	}
    	
    	return "unauthorized";
    }
    
    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public String createEmployeePost(@Valid @ModelAttribute("employee") Employee employee, 
    									BindingResult result,
    									HttpSession session, 
    									Model model){
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	
    	if (currentEmployee.getIsAdmin()) {
    		model.addAttribute("adminToolbar", "true");
    		if(result.hasErrors()){
    			model.addAttribute("createMessage", result.getFieldError().getField() + " contains some error");
    			return "createEmployee";
    		}
    		else{
    			Employee newEmployee = employeeService.save(employee);
    			if(newEmployee==null)
    				model.addAttribute("createMessage", "Saving employee to DB failed.");
    			else
    				model.addAttribute("createMessage", "Creating employee Successful.");
    			return "createEmployee";
    		}
    	}
    	
    	return "unauthorized";
    }
}
