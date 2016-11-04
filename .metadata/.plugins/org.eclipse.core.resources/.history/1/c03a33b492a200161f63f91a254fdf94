package project.persistence.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	private String fullName;
	
	//@Column(unique = true)
	private String loginName;
	private String loginPassword;
	
	// Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String socialSecurity;
	private String phoneNumber;
	private String homeAddress;
	private Date dateOfEmployment;
	private float hourlyRate;
	private String defaultDepartment;
	
	public Employee(){
		
	}
	
	public Employee(String fullName,
					String loginName,
					String loginPassword,
					long id,
					String socialSecurity,
					String phoneNumber,
					String homeAddress,
					Date dateOfEmployment,
					float hourlyRate,
					String defaultDepartment){
		this.fullName = fullName;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.id = id;
		this.socialSecurity = socialSecurity;
		this.phoneNumber = phoneNumber;
		this.homeAddress = homeAddress;
		this.dateOfEmployment = dateOfEmployment;
		this.hourlyRate = hourlyRate;
		this.defaultDepartment = defaultDepartment;
	}
	
	public String getFullname() {
		return fullName;
	}
	public void setFullname(String fullname) {
		this.fullName = fullname;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSocialSecurity() {
		return socialSecurity;
	}
	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getHomeAddrass() {
		return homeAddress;
	}
	public void setHomeAddrass(String homeAddrass) {
		this.homeAddress = homeAddrass;
	}
	public Date getDateOfEmployement() {
		return dateOfEmployment;
	}
	public void setDateOfEmployement(Date dateOfEmployement) {
		this.dateOfEmployment = dateOfEmployement;
	}
	public float getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public String getDefaultDepartment() {
		return defaultDepartment;
	}
	public void setDefaultDepartment(String defaultDepartment) {
		this.defaultDepartment = defaultDepartment;
	}
	
	

}
