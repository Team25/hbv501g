package project.persistence.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "Entry_Comment")
public class Comment {

	@Id
	@Column(name = "CommentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Entry entry;
	private Long employeeId;
	private String text;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(fetch = FetchType.EAGER,
			optional = false)
	@JoinColumn(name = "EntryId")
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
