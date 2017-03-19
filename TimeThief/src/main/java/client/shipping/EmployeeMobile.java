package client.shipping;

public class EmployeeMobile {

	private String fullName;
	
	private Long id;    

	private String phoneNumber;
	
	private String token;

	
	public EmployeeMobile(String fullName, Long id, String phoneNumber, String token) {
		this.fullName = fullName;
		this.id = id;
		this.phoneNumber = phoneNumber;
		this.token = token;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getToken() { return token; }

    public void setToken(String token) { this.token = token; }
	
	
}
