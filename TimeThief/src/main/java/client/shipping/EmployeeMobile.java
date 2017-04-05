package client.shipping;

import project.persistence.entities.Employee;

public class EmployeeMobile {

	private String mFullName;
	private Long mId;    
	private String mPhoneNumber;
	private String mToken;

	
	public EmployeeMobile(String mFullName, Long mId, String mPhoneNumber, String mToken) {
		this.mFullName =mFullName;
		this.mId = mId;
		this.mPhoneNumber = mPhoneNumber;
		this.mToken = mToken;
	}

	public EmployeeMobile(Employee e) {
		this.mFullName = e.getFullName();
		this.mId = e.getId();
		this.mPhoneNumber = e.getPhoneNumber();
		this.mToken = e.getToken();
	}

	public String getmFullName() {
		return mFullName;
	}

	public void setmFullName(String mFullName) {
		this.mFullName = mFullName;
	}

	public Long getmId() {
		return mId;
	}

	public void setmId(Long mId) {
		this.mId = mId;
	}

	public String getmPhoneNumber() {
		return mPhoneNumber;
	}

	public void setmPhoneNumber(String mPhoneNumber) {
		this.mPhoneNumber = mPhoneNumber;
	}

	public String getmToken() {
		return mToken;
	}

	public void setmToken(String mToken) {
		this.mToken = mToken;
	}
	
	
}
