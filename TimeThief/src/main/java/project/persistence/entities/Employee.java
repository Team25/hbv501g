package project.persistence.entities;

import java.util.Date;
//import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="employee")
public class Employee {
	@NotNull
    @Size(min=1, max=64)
	private String fullName;
	
	@NotNull
    @Size(min=1, max=64)
	@Column(unique = true)
	private String loginName;
	@NotNull
	private String loginPassword;
	
	// Declare that this attribute is the id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @NotNull
    @Size(min=1, max=11)
	private String socialSecurity;
    
    @NotNull
    @Pattern(regexp ="\\d{3}-\\d{4}")
	private String phoneNumber;
    
    @NotNull
    @Size(min=1, max=64)
	private String homeAddress;
    
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfEmployment;
	
	private float hourlyRate;
	
	@NotNull
    @Size(min=1, max=64)
	private String defaultDepartment;
	private boolean isAdmin;
	
	@Column(unique = true)
	private String token;
	
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
					String defaultDepartment,
					boolean isAdmin,
					String token){
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
		this.isAdmin = isAdmin;
		this.token = token;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public Long getId() {
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
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddrass) {
		this.homeAddress = homeAddrass;
	}
	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(Date dateOfEmployement) {
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
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
}
