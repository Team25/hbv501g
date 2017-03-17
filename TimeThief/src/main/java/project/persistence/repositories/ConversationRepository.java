package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Conversation;
import project.persistence.entities.Employee;

public interface ConversationRepository  extends JpaRepository<Conversation, Long>{
	
	@SuppressWarnings("unchecked")
	Conversation save(Conversation Conversation);

    void delete(Conversation Conversation);
    
    Conversation findOne(Long id);
    
    List<Conversation> findAll();
    
    List<Conversation> findByMembers(List<Employee> members);
}
