package client.shipping;

import java.util.ArrayList;
import java.util.List;

import project.persistence.entities.Conversation;
import project.persistence.entities.Employee;

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

	public ConversationMobile(Conversation conversation) {
		this.mId = conversation.getId();
		List<EmployeeMobile> members = new ArrayList<EmployeeMobile>();
		//TODO: Perhaps check if members list doesnt always include members!
		for(Employee e: conversation.getMembers()){
			members.add(new EmployeeMobile(e));
		}
		this.mMembers = members;
		this.mMessages = null;
		this.mMessageCount = 0;
	}

	public long getmId() {
		return mId;
	}

	public void setmId(long id) {
		this.mId = id;
	}

	public List<EmployeeMobile> getmMembers() {
		return mMembers;
	}

	public void setmMembers(List<EmployeeMobile> members) {
		this.mMembers = members;
	}

	public List<MessageMobile> getmMessages() {
		return mMessages;
	}

	public void setmMessages(List<MessageMobile> messages) {
		this.mMessages = messages;
	}

	public int getmMessageCount() {
		return mMessageCount;
	}

	public void setmMessageCount(int messageCount) {
		this.mMessageCount = messageCount;
	}
	
}
