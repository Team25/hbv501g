package client.shipping;

import project.persistence.entities.Comment;

public class CommentMobile {

    private long mId;
    private EntryMobile mEntry;
    private EmployeeMobile mEmployee;
    private String mText;
    
	public CommentMobile(long id, EntryMobile entry, EmployeeMobile employee, String text) {
		this.mId = id;
		this.mEntry = entry;
		this.mEmployee = employee;
		this.mText = text;
	}
	
	public CommentMobile(Comment comment, EntryMobile entry) {
		this.mId = comment.getId();
		this.mEntry = entry;
		//TODO consider using fixing server side connection between comment and employee.
		this.mEmployee = null;
		this.mText = comment.getText();
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	public EntryMobile getEntry() {
		return mEntry;
	}

	public void setEntry(EntryMobile entry) {
		this.mEntry = entry;
	}

	public EmployeeMobile getEmployee() {
		return mEmployee;
	}

	public void setEmployee(EmployeeMobile employee) {
		this.mEmployee = employee;
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		this.mText = text;
	}

    
}