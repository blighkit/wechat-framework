package blighkit.wechat.bean.in;

public class LinkInMessage extends InMessage {

	private String Title;
	private String Description;
	private String Url;

	public LinkInMessage(String title, String description, String url) {
		Title = title;
		Description = description;
		Url = url;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
