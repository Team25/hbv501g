package client.shipping;

public class EmployeeMobile {

	private String mFullName;
	
	private Long mId;    

	private String mPhoneNumber;
	
	private String mToken;

	
	public EmployeeMobile(String fullName, Long id, String phoneNumber, String token) {
		this.mFullName = fullName;
		this.mId = id;
		this.mPhoneNumber = phoneNumber;
		this.mToken = token;
	}

	public String getFullName() {
		return mFullName;
	}

	public void setFullName(String fullName) {
		this.mFullName = fullName;
	}

	public Long getId() {
		return mId;
	}

	public void setId(Long id) {
		this.mId = id;
	}

	public String getPhoneNumber() {
		return mPhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.mPhoneNumber = phoneNumber;
	}
	
	public String getToken() { return mToken; }

    public void setToken(String token) { this.mToken = token; }
	
	
}
