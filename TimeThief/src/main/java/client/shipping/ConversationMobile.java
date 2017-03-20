package client.shipping;

import java.util.List;

public class ConversationMobile {
	
	private long mId;
	private List<EmployeeMobile> mMembers;
	private List<MessageMobile> mMessages;
	private int mMessageCount;
	
	public ConversationMobile(long id, List<EmployeeMobile> members, List<MessageMobile> messages, int messageCount) {
		this.mId = id;
		this.mMembers = members;
		this.mMessages = messages;
		this.mMessageCount = messageCount;
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	public List<EmployeeMobile> getMembers() {
		return mMembers;
	}

	public void setMembers(List<EmployeeMobile> members) {
		this.mMembers = members;
	}

	public List<MessageMobile> getMessages() {
		return mMessages;
	}

	public void setMessages(List<MessageMobile> messages) {
		this.mMessages = messages;
	}

	public int getMessageCount() {
		return mMessageCount;
	}

	public void setMessageCount(int messageCount) {
		this.mMessageCount = messageCount;
	}
	
}
