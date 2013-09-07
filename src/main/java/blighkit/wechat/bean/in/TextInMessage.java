package blighkit.wechat.bean.in;

public class TextInMessage extends InMessage {

	private String Content;

	public TextInMessage(String Content) {
		this.Content = Content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
