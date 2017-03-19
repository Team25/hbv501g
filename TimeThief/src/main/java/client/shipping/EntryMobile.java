package client.shipping;

import java.sql.Timestamp;
import java.util.List;

public class EntryMobile {
	private long id;
	private List<CommentMobile> comments;
	private String department;
	private Timestamp inTime;
	private Timestamp outTime;
	private boolean isVerified;
	
	
	
	public EntryMobile(long id, List<CommentMobile> comments, String department, Timestamp inTime, Timestamp outTime,
			boolean isVerified) {
		this.id = id;
		this.comments = comments;
		this.department = department;
		this.inTime = inTime;
		this.outTime = outTime;
		this.isVerified = isVerified;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<CommentMobile> getComments() {
		return comments;
	}
	public void setComments(List<CommentMobile> comments) {
		this.comments = comments;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Timestamp getInTime() {
		return inTime;
	}
	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}
	public Timestamp getOutTime() {
		return outTime;
	}
	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
}
