package client.shipping;

import project.persistence.entities.Comment;

public class CommentMobile {

    private long id;
    private EntryMobile entry;
    private EmployeeMobile employee;
    private String text;
    
	public CommentMobile(long id, EntryMobile entry, EmployeeMobile employee, String text) {
		this.id = id;
		this.entry = entry;
		this.employee = employee;
		this.text = text;
	}
	
	public CommentMobile(Comment comment, EntryMobile entry) {
		this.id = comment.getId();
		this.entry = entry;
		//TODO consider using fixing server side connection between comment and employee.
		this.employee = null;
		this.text = comment.getText();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EntryMobile getEntry() {
		return entry;
	}

	public void setEntry(EntryMobile entry) {
		this.entry = entry;
	}

	public EmployeeMobile getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeMobile employee) {
		this.employee = employee;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

    
}