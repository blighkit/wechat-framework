package blighkit.wechat.bean.out;

import blighkit.wechat.bean.in.InMessage;

public abstract class OutMessage {

	private String toUserName;

	private String fromUserName;

	public OutMessage(InMessage inMessage) {
		this.toUserName = inMessage.getFromUserName();
		this.fromUserName = inMessage.getToUserName();
	}

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFromUserName() {
		return fromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

    @Override
    public String toString() {

        return getFromUserName()+" -> "+getToUserName();
    }
}
