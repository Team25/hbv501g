package client.shipping;

import java.util.Date;
import java.util.List;

import project.persistence.entities.Entry;

public class EntryMobile {
	private long id;
	private List<CommentMobile> comments;
	private String department;
	private Date inTime;
	private Date outTime;
	private boolean isVerified;
	
	
	
	public EntryMobile(long id, List<CommentMobile> comments, String department, Date inTime, Date outTime,
			boolean isVerified) {
		this.id = id;
		this.comments = comments;
		this.department = department;
		this.inTime = inTime;
		this.outTime = outTime;
		this.isVerified = isVerified;
	}
	
	//contstructor for sending entries to mobile
	public EntryMobile(Entry entry){
		this.id = entry.getId();
		//TODO change all items in list to CommentMobile
		this.comments = null;
		this.department = entry.getDepartment();
		this.inTime = entry.getInTime();
		this.outTime = entry.getOutTime();
		this.isVerified = entry.getIsVerified();
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
	public Date getInTime() {
		return inTime;
	}
	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}
	public Date getOutTime() {
		return outTime;
	}
	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	
}
