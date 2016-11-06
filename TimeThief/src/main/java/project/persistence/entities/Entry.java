package project.persistence.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="entry")
public class Entry {
	
	@Id
	@Column(name = "EntryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private List<Comment> comments;
	private String department;
	private Timestamp inTime;
	private Timestamp outTime;
	private boolean state;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	
	@OneToMany(mappedBy ="entry",
			fetch = FetchType.LAZY,
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
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
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	

}