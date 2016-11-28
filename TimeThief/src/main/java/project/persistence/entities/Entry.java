package project.persistence.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "entry")
public class Entry {
	
	@Id
	@Column(name = "entryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	
	@OneToMany(mappedBy = "entry",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Comment> comments;
	private String department;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date inTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date outTime;
	private boolean isVerified;
	
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
	public boolean getIsVerified() {
		return isVerified;
	}
	public void setIsVerified(boolean state) {
		this.isVerified = state;
	}
	

}
