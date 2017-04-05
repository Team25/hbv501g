package project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.shipping.ConversationMobile;
import client.shipping.EmployeeMobile;

import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Conversation;
import project.persistence.entities.Employee;

import project.service.EmployeeService;
import project.service.MessageService;


@RestController
public class EmployeeRESTController {
	
	EmployeeService employeeService;
	MessageService messageService;
	
	public EmployeeRESTController(MessageService messageService, EmployeeService employeeService) {
		this.messageService = messageService;
		this.employeeService = employeeService;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appemployeelist", produces = "application/json")
	public ArrayList<EmployeeMobile> getEmployeeList(String token){
		
		//TODO check if token is valid
		
		List<Employee> employees = employeeService.findAll();
		ArrayList<EmployeeMobile> mobileEmployees = new ArrayList<EmployeeMobile>();
		for(Employee e: employees){
			EmployeeMobile mobileEmployee = new EmployeeMobile(e);
			mobileEmployees.add(mobileEmployee);
		}
		
		return mobileEmployees;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/appgetconversation", produces = "application/json")
	public ConversationMobile getConversation(String token, long conversationist){
		
		//TODO check if token is valid
		
		Employee person1 = employeeService.findByToken(token);
		if (person1 == null)
			System.err.println("SOMETHING HAS GONE HORRIBLY WRONG");
		Employee person2 = employeeService.findOne(conversationist);
		List<Employee> conversationParticipants = new ArrayList<Employee>();
		conversationParticipants.add(person2);
		conversationParticipants.add(person1);
		Conversation conversationExample = new Conversation();
		conversationExample.setMembers(conversationParticipants);
		System.err.println(""+conversationExample.getMembers().get(0).getFullName());
		//System.err.println(""+conversationExample.getMembers().get(1).getFullName());
		List<Conversation> conversation = messageService.findConversationByExample(conversationExample);
		System.err.println("size of list is: " + conversation.size());
		Conversation newConversation;
		// Check if conversation exists... if not, make one.
		if(conversation!=null && conversation.isEmpty()){
			newConversation = messageService.saveConversation(conversationExample);
		} else {
			System.err.println("Id of conversation is: "+ conversation.get(0).getId() );
			newConversation = conversation.get(0);
		}
		//TODO check if conversation exists before doing this... make one if doesnt exist.
		System.err.println("lalalu");
		ConversationMobile conversationMobile = new ConversationMobile(newConversation);
		System.err.println("lulula");
		System.err.println(conversationMobile.getmId()+"");
		return conversationMobile;
	}
	
	
	
	// TODO put in rest of methods for this controller.

}
