package client.shipping;

import java.sql.Timestamp;

public class MessageMobile {
	
	private long mId;
	private ConversationMobile mConversation;
	private EmployeeMobile mSender;
	private Timestamp mSentTime;
	private String mText;
	
	public MessageMobile(long id, ConversationMobile conversation, EmployeeMobile sender, Timestamp sentTime,
			String text) {
		this.mId = id;
		this.mConversation = conversation;
		this.mSender = sender;
		this.mSentTime = sentTime;
		this.mText = text;
	}

	public long getId() {
		return mId;
	}

	public void setId(long id) {
		this.mId = id;
	}

	public ConversationMobile getConversation() {
		return mConversation;
	}

	public void setConversation(ConversationMobile conversation) {
		this.mConversation = conversation;
	}

	public EmployeeMobile getSender() {
		return mSender;
	}

	public void setSender(EmployeeMobile sender) {
		this.mSender = sender;
	}

	public Timestamp getSentTime() {
		return mSentTime;
	}

	public void setSentTime(Timestamp sentTime) {
		this.mSentTime = sentTime;
	}

	public String getText() {
		return mText;
	}

	public void setText(String text) {
		this.mText = text;
	}

	
	
}
