package client.shipping;

import java.util.Date;
import java.util.List;

import project.persistence.entities.Entry;

public class EntryMobile {
	private long mId;
	private List<CommentMobile> mComments;
	private String mDepartment;
	private Date mInTime;
	private Date mOutTime;
	private boolean mIsVerified;
	
	
	
	public EntryMobile(long id, List<CommentMobile> comments, String department, Date inTime, Date outTime,
			boolean isVerified) {
		this.mId = id;
		this.mComments = comments;
		this.mDepartment = department;
		this.mInTime = inTime;
		this.mOutTime = outTime;
		this.mIsVerified = isVerified;
	}
	
	//contstructor for sending entries to mobile
	public EntryMobile(Entry entry){
		this.mId = entry.getId();
		//TODO change all items in list to CommentMobile
		this.mComments = null;
		this.mDepartment = entry.getDepartment();
		this.mInTime = entry.getInTime();
		this.mOutTime = entry.getOutTime();
		this.mIsVerified = entry.getIsVerified();
	}
	
	public long getmId() {
		return mId;
	}
	public void setmId(long id) {
		this.mId = id;
	}
	public List<CommentMobile> getmComments() {
		return mComments;
	}
	public void setmComments(List<CommentMobile> comments) {
		this.mComments = comments;
	}
	public String getmDepartment() {
		return mDepartment;
	}
	public void setmDepartment(String department) {
		this.mDepartment = department;
	}
	public Date getmInTime() {
		return mInTime;
	}
	public void setmInTime(Date inTime) {
		this.mInTime = inTime;
	}
	public Date getmOutTime() {
		return mOutTime;
	}
	public void setmOutTime(Date outTime) {
		this.mOutTime = outTime;
	}
	public boolean ismVerified() {
		return mIsVerified;
	}
	public void setmVerified(boolean isVerified) {
		this.mIsVerified = isVerified;
	}
	
	
}
