package project.persistence.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="conversation")
public class Conversation {
	
	@Id
	@Column(name = "conversationId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="conversation_id"), inverseJoinColumns=@JoinColumn(name="members_id"))  
	private List<Employee> members;
	
	@OneToMany(mappedBy = "conversation",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<Message> messages;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public List<Employee> getMembers() {
		return members;
	}

	public void setMembers(List<Employee> members) {
		this.members = members;
	}
	

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
}
