package project.service.Implementation;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import client.shipping.EmployeeMobile;
import client.shipping.TokenInfo;
import project.persistence.entities.Employee;
import project.persistence.repositories.EmployeeRepository;
import project.service.EmployeeService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	EmployeeRepository repository;
	
	@Autowired
    public EmployeeServiceImplementation(EmployeeRepository repository) {
        this.repository = repository;
    }
	
	@Override
	public Employee save(Employee employee){
		String hashedPassword = "";
		if(employee.getLoginPassword().equals("")){
			Employee tmp = repository.findOne(employee.getId());
			hashedPassword = tmp.getLoginPassword();
		} else {
			hashedPassword = hashString(employee.getLoginPassword());
		}
		employee.setLoginPassword(hashedPassword);
		return repository.save(employee);
	}
	
	@Override
	public void delete(Employee employee){
        repository.delete(employee);
	}
	
	@Override
	public List<Employee> findAll(){
		return repository.findAll();
	}
	
	@Override
	public List<Employee> findByFullName(String fullName){
		return repository.findByFullName(fullName);
	}
	
	@Override
	public List<Employee> findByLoginName(String loginName){
		return repository.findByLoginName(loginName);
	}
	
	@Override
	public List<Employee> findByLoginNameOrFullName(String searchString) {
		return repository.findByLoginNameContainingIgnoreCaseOrFullNameContainingIgnoreCase(searchString, searchString);
	}
	
	@Override
	public Employee findOne(Long id){
		return repository.findOne(id);
	}
	
	@Override
	public Employee verifyLogin(String user, String password){
		List<Employee> listWithEmployee = repository.findByLoginName(user);
		Employee thisEmployee = null;
		
		if(!listWithEmployee.isEmpty()){
			thisEmployee = listWithEmployee.get(0);
			
			if(hashString(password).equals(thisEmployee.getLoginPassword())){
				return thisEmployee;
			}
		}
		return null;
	}
	
	@Override // not in uml
	public Employee findByToken(String token) {
		List<Employee> employees = repository.findByToken(token);
		
		if (employees == null || employees.isEmpty()) return null;
		else return employees.get(0);
	}
	
	@Override
	public EmployeeMobile isValidToken(String token) {
		List<Employee> employees = repository.findByToken(token);
		
		if (employees == null || employees.isEmpty()) return null;
		
		Employee emp = employees.get(0);
		
		EmployeeMobile employee = new EmployeeMobile(emp.getFullName(),
													emp.getId(),
													emp.getPhoneNumber(),
													emp.getToken());
		
		return employee;
	}
	
	private String hashString(String str) {
		String HashedString = "";
		byte[] strBytes = str.getBytes();
		
		try {
			MessageDigest hasher = MessageDigest.getInstance("SHA-224");
			hasher.update(strBytes);
			byte[] HashedBytes = hasher.digest();
			HashedString = DatatypeConverter.printHexBinary(HashedBytes);
		} catch (NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
		}
		
		return HashedString;	
	}
	
	// not in uml
	public String createToken(Employee employee) {
		// Búum til token með því að hasha random streng.
		Random rand = new Random();
		int randomNumber = rand.nextInt(100000);
		
		String randomString = employee.getLoginName() + employee.getLoginPassword() + randomNumber;
		
		String token = hashString(randomString);
		
		// vistum token í grunn.
		employee.setToken(token);
		repository.save(employee);
		
		// skilum token til controller > client.
		return token;
	}
	
	public boolean resetPassword(String loginName){
		System.out.println(loginName);
		List<Employee> namelist = findByLoginName(loginName);
		if(namelist.isEmpty()||namelist.size()>1) return false;
		
		/*
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String newpass = "";
		for(int i = 0; i < 8; i++) {
			newpass = newpass + candidateChars.charAt(random.nextInt(candidateChars.length()));
		}
		*/
		
		String newpassword = "abc";
		
		//TBD að senda newpassword í t-pósti til notanda
		//og þá velja nýtt password af handahófi
		
		
		Employee employee = namelist.get(0);
		String sendtoemail = employee.getEmailAddress();
		String employeeName = employee.getFullName();
		
		/*
		Properties props = new Properties();
		//skipta út server fyrir eitthvað annað
	    props.put("mail.smtp.host", "my-mail-server");
	    Session session = Session.getInstance(props, null);

	    try {
	        MimeMessage msg = new MimeMessage(session);
	        msg.setFrom("noreply@timethief.biz");
	        msg.setRecipients(Message.RecipientType.TO,
	                          sendtoemail);
	        msg.setSubject("Your new password");
	        msg.setSentDate(new Date());
	        msg.setText("Greetings "+employeeName+"\n\nYour new password for Timethief/Timerunner is: "+newpassword+
	        "Best regards\nTeam25inc" );
	        Transport.send(msg, "me@example.com", "my-password");
	    } catch (MessagingException mex) {
	        System.out.println("send failed, exception: " + mex);
	        return false;
	    }
	    */
		
		String hashedPassword = hashString(newpassword);
		employee.setLoginPassword(hashedPassword);
		repository.save(employee);
		return true;
	}
}
