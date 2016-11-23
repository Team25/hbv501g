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
import project.persistence.entities.Entry;
import project.service.EntryService;

@Controller
public class EntryController {
	
	// Instance Variables
    EntryService entryService;

    // Dependency Injection
    @Autowired
    public EntryController(EntryService entryService) {
        this.entryService = entryService;
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
    public String viewEmployeeById(@PathVariable Long entryId, HttpSession session, Model model){
    	
    	Long userId = (Long)session.getAttribute("loggedInUser");
    	if(userId==null)
    		return "redirect:/login";
    	
    	Entry currentEntry = entryService.findOne(entryId);
    	if(currentEntry.getEmployeeId().equals(userId)){
    		model.addAttribute("entry", currentEntry);
    		return "entryOwn";
    	}
       	return "unauthorized";
    }
    
}