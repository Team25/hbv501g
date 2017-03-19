package client.shipping;

import java.util.List;

public class ConversationMobile {
	
	private long id;
	private List<EmployeeMobile> members;
	private List<MessageMobile> messages;
	private int messageCount;
	
	public ConversationMobile(long id, List<EmployeeMobile> members, List<MessageMobile> messages, int messageCount) {
		this.id = id;
		this.members = members;
		this.messages = messages;
		this.messageCount = messageCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<EmployeeMobile> getMembers() {
		return members;
	}

	public void setMembers(List<EmployeeMobile> members) {
		this.members = members;
	}

	public List<MessageMobile> getMessages() {
		return messages;
	}

	public void setMessages(List<MessageMobile> messages) {
		this.messages = messages;
	}

	public int getMessageCount() {
		return messageCount;
	}

	public void setMessageCount(int messageCount) {
		this.messageCount = messageCount;
	}
	
}
