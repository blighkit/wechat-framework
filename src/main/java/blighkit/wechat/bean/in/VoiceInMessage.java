package blighkit.wechat.bean.in;

public class VoiceInMessage extends InMessage {

	private String MediaId;
	private String Format;
	private String Recognition;


	
	public VoiceInMessage(String mediaId, String format, String recognition) {
		
		MediaId = mediaId;
		Format = format;
		Recognition = recognition;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
