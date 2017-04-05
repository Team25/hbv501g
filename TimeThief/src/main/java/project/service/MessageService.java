package project.service;

import java.util.List;

import project.persistence.entities.Conversation;
import project.persistence.entities.Message;

/**
 * Service class that has methods for String Manipulation
 *
 * DISCLAIMER:  This class is just for demonstration purposes,
 *              something basic as this would be handled where it is needed
 */
public interface MessageService {
	

	Message saveMessage(Message message);
	
	void deleteMessage(Message message);
	
	List<Message> findAllMessages();
	
	Message findOneMessage(long id);
	
	List<Message> findMessagesByConversation(int offset, int numberOfMessages, Conversation conversation);
	
	Conversation saveConversation(Conversation conversation);
	
	void deleteConversation(Conversation conversation);
	
	List<Conversation> findAllConversations();
	
	Conversation findOneConversation(long id);
	
	List<Conversation> findConversationByExample(Conversation conversation);
	
	
}