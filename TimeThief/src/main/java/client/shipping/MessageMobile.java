package client.shipping;

import java.sql.Timestamp;

public class MessageMobile {
	
	private long id;
	private ConversationMobile conversation;
	private EmployeeMobile sender;
	private Timestamp sentTime;
	private String text;
	
	public MessageMobile(long id, ConversationMobile conversation, EmployeeMobile sender, Timestamp sentTime,
			String text) {
		this.id = id;
		this.conversation = conversation;
		this.sender = sender;
		this.sentTime = sentTime;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ConversationMobile getConversation() {
		return conversation;
	}

	public void setConversation(ConversationMobile conversation) {
		this.conversation = conversation;
	}

	public EmployeeMobile getSender() {
		return sender;
	}

	public void setSender(EmployeeMobile sender) {
		this.sender = sender;
	}

	public Timestamp getSentTime() {
		return sentTime;
	}

	public void setSentTime(Timestamp sentTime) {
		this.sentTime = sentTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}
