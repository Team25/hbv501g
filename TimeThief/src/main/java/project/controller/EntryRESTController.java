package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.EntryMobile;
import project.persistence.entities.Employee;
import project.persistence.entities.Entry;
import project.service.EmployeeService;
import project.service.EntryService;

@RestController
public class EntryRESTController {
	
	EntryService entryService;
	EmployeeService employeeService; // not in uml
	
	public EntryRESTController(EntryService entryService, EmployeeService employeeService) { // not in uml
		this.entryService = entryService;
		this.employeeService = employeeService; // not in uml
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appgetentries", produces = "application/json")
	public List<EntryMobile> getAttendanceList(String token) {
		Employee employee = employeeService.findByToken(token);
				if (employee == null) return null;
		
			
		List<Entry> entries = entryService.findByEmployeeId(employee.getId());
		List<EntryMobile> entriesMobile = new ArrayList<EntryMobile>();
		for(Entry e : entries){
			entriesMobile.add(new EntryMobile(e));
		}
		return entriesMobile;
	}
	
}
