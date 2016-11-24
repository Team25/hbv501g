package project.persistence.entities;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@Column(name = "commentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne
	@JoinColumn(name = "entryId")
	private Entry entry;
	
	private Long employeeId;
	private String employeeName;
	private String text;
	private Timestamp timestamp;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Entry getEntry() {
		return entry;
	}
	
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}
}
