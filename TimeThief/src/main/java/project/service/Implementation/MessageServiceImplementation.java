package project.service.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Conversation;
import project.persistence.entities.Message;
import project.persistence.repositories.ConversationRepository;
import project.persistence.repositories.MessageRepository;
import project.service.MessageService;

@Service
public class MessageServiceImplementation implements MessageService {
	
	private MessageRepository messageRepository;
	private ConversationRepository conversationRepository;
	
	@Autowired
    public MessageServiceImplementation(MessageRepository messageRepository, ConversationRepository conversationRepository) {
        this.messageRepository = messageRepository;
        this.conversationRepository = conversationRepository;
    }
	
	@Override
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}
	@Override
	public void deleteMessage(Message message) {
		messageRepository.delete(message);
		
	}
	@Override
	public List<Message> findAllMessages() {
		return messageRepository.findAll();
	}
	@Override
	public Message findOneMessage(long id) {
		return messageRepository.findOne(id);
	}
	@Override
	public Conversation saveConversation(Conversation conversation) {
		return conversationRepository.save(conversation);
	}
	@Override
	public void deleteConversation(Conversation conversation) {
		conversationRepository.delete(conversation);		
	}
	@Override
	public List<Conversation> findAllConversations() {
		return conversationRepository.findAll();
	}
	@Override
	public Conversation findOneConversation(long id) {
		return conversationRepository.findOne(id);
	}

	// ekki í uml
	@Override
	public List<Message> findMessagesByConversation(int offset, int numberOfMessages, Conversation conversation) {
		List<Message> messages = messageRepository.findByConversationOrderBySentTime(conversation);
		// see if offset is larger then amount of messages
		if(messages.size()>offset || offset<0){
			return null;
		} 
		// see if the amount of requested messages exceed the amount of messages available after offset
		// if so then we return all messages from offset to end of list.
		else if(messages.size()>(offset + numberOfMessages) ){
			return messages.subList(offset, messages.size());
		}
		return messages.subList(offset, offset+numberOfMessages);
	}
	
	

}
