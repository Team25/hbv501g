package project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Comment;
import project.persistence.entities.Employee;
import project.persistence.entities.Entry;
import project.service.EmployeeService;
import project.service.EntryService;

@Controller
public class EntryController {
	
	// Instance Variables
    EntryService entryService;
    EmployeeService employeeService;

    // Dependency Injection
    @Autowired
    public EntryController(EntryService entryService, EmployeeService employeeService) {
        this.entryService = entryService;
        this.employeeService = employeeService;
    }
    
    @RequestMapping(value = "/entry/view/own", method = RequestMethod.GET)
    public String viewOwnEntriesDefault(HttpSession session, Model model){
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	
    	List<Entry> entries = entryService.findByEmployeeId(userId);
    	model.addAttribute("entryList", entries);
    	
    	return "entries/entryList";
    }
    
    @RequestMapping(value = "/entry/view/own/{entryId}", method = RequestMethod.GET)
    public String viewOwnEntryById(@PathVariable Long entryId, HttpSession session, Model model){
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	
    	Entry currentEntry = entryService.findOne(entryId);
    	if(currentEntry.getEmployeeId().equals(userId)){
    		model.addAttribute("entry", currentEntry);
    		Comment comment = new Comment();
    		model.addAttribute("comment", comment);
    		return "entries/entryOwn";
    	}
       	return "unauthorized";
    }
    
    @RequestMapping(value = "entry/view/own/{entryId}", method = RequestMethod.POST)
    public String viewOwnEntryCommentsPost(@PathVariable Long entryId, @Valid @ModelAttribute("comment") Comment comment, 
			BindingResult result,
			HttpSession session, 
			Model model){
    	
    	// see if user is logged in, if not then redirect him to login page
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	Entry currentEntry = entryService.findOne(entryId);
    	if(currentEntry.getEmployeeId().equals(userId)){
    		if(result.hasErrors()){
    			model.addAttribute("commentMessage", result.getFieldError().getField() + " contains some error");
    			return "entries/entryOwn";
    		}
    		List<Comment> commentsOfCurrentEntry = currentEntry.getComments();
    		comment.setEmployeeId(userId);
    		comment.setEntry(currentEntry);
    		comment.setEmployeeName(currentEmployee.getFullName());
    		comment.setTimestamp(new Timestamp(System.currentTimeMillis()));
    		commentsOfCurrentEntry.add(commentsOfCurrentEntry.size(), comment);
    		currentEntry.setComments(commentsOfCurrentEntry);
    		currentEntry.setIsVerified(false);
    		currentEntry = entryService.save(currentEntry);
    		model.addAttribute("entry", currentEntry);
    		model.addAttribute("comment", new Comment());
    		return "entries/entryOwn";
    	}
    	
    	return "unauthorized";
	}
    
    @RequestMapping(value = "/entry/view/all", method = RequestMethod.GET)
    public String viewAllEntries(HttpSession session, Model model){
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	
    	Employee currentEmployee = employeeService.findOne(userId);
    	if(!currentEmployee.getIsAdmin()){
    		return "unauthorized";
    	}
    	Entry example = new Entry();
    	List<Entry> entries = entryService.findByExample(example);
    	model.addAttribute("entryList", entries);
    	
    	return "entries/entryList";
    }
    
}