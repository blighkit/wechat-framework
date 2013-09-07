package blighkit.wechat.bean.in;

public class ClickInMessage extends InMessage {

	private String EventKey;

	public ClickInMessage(String EventKey) {

		this.EventKey = EventKey;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
