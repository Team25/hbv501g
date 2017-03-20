package project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.EntryMobile;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import project.persistence.entities.Entry;
import project.persistence.entities.Employee;

import project.service.EmployeeService;
import project.service.EntryService;


@RestController
public class ClockRESTController {

	EntryService entryService;
	EmployeeService employeeService; // not in uml
	
	public ClockRESTController(EntryService entryService, EmployeeService employeeService) { // not in uml
		this.entryService = entryService;
		this.employeeService = employeeService; // not in uml
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appclock", produces = "application/json")
	public EntryMobile clockInOut(String token, @RequestParam(required = false) String department) {
		Employee employee = employeeService.findByToken(token);
		
		if (employee == null) return null;
		
		if (department == null) { 
			// Þá er employee ekki clocked in. Auðveldara svo client þurfi ekki að 
			// vita department við clockOut.
			Entry currentEntry = entryService.isEmployeeClockedIn(employee.getId());
			department = currentEntry.getDepartment();
		}
			
		Entry entry = entryService.clock(employee.getId(), department);
		return new EntryMobile(entry);
	}
	
	// til hvers var þessi gæji yfir höfuð ?
	@RequestMapping(method = RequestMethod.GET, value = "/appentry", produces = "application/json")
	public EntryMobile getOpenClockEntry(String token) {
		Employee employee = employeeService.findByToken(token);
		if (employee == null) return null;
		Entry entry = entryService.isEmployeeClockedIn(employee.getId());	
		if(entry == null){
			return null;
		}
		EntryMobile entryM = new EntryMobile(entry);
		return entryM; // er null ef ekkert entry
	}
}
