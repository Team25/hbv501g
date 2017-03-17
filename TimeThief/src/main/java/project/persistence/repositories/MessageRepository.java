package project.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Conversation;
import project.persistence.entities.Message;

public interface MessageRepository  extends JpaRepository<Message, Long>{
	
	@SuppressWarnings("unchecked")
	Message save(Message message);

    void delete(Message message);
    
    Message findOne(Long id);
    
    List<Message> findAll();
    
    List<Message> findByConversationOrderBySentTime(Conversation conversation);
}