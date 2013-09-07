package blighkit.wechat.bean.in;

public class ImageInMessage extends InMessage {

	private String PicUrl;

	public ImageInMessage(String PicUrl) {
		this.PicUrl = PicUrl;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

}
