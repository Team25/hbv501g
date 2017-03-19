package project.service;

import java.util.List;

import client.shipping.EmployeeMobile;
import client.shipping.TokenInfo;
import project.persistence.entities.Employee;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
public interface EmployeeService {
	

	Employee save(Employee employee);
	
	void delete(Employee employee);
	
	List<Employee> findAll();
	
	List<Employee> findByFullName(String fullname);
	
	List<Employee> findByLoginName(String fullName);
	
	List<Employee> findByLoginNameOrFullName(String searchString);
	
	Employee findOne(Long id);
	
	Employee verifyLogin(String user, String password);
	
	Employee findByToken(String token); // not in uml
	
	EmployeeMobile isValidToken(String token);
	
	String createToken(Employee employee); // not in uml
}
