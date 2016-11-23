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
    
}