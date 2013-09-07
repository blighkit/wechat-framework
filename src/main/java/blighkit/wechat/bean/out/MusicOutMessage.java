package blighkit.wechat.bean.out;

import blighkit.wechat.bean.in.InMessage;

public class MusicOutMessage extends OutMessage {
	public MusicOutMessage(InMessage inMessage) {
		super(inMessage);
	}

	private String title;
	private String description;
	private String musicUrl;
	private String hqMusicUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String getHqMusicUrl() {
		return hqMusicUrl;
	}

	public void setHqMusicUrl(String hqMusicUrl) {
		this.hqMusicUrl = hqMusicUrl;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>\n<ToUserName><![CDATA[");
        sb.append(getToUserName());
        sb.append("]]></ToUserName>\n<FromUserName><![CDATA[");
        sb.append(getFromUserName());
        sb.append("]]></FromUserName>\n<CreateTime>");
        sb.append(System.currentTimeMillis());
        sb.append("</CreateTime>\n<MsgType><![CDATA[music]]></MsgType>\n<Music>"
                + "\n<Title><![CDATA[" + getTitle() + "]]></Title>"
                + "\n<Description><![CDATA[" + getDescription()
                + "]]></Description>\n<MusicUrl><![CDATA["
                + getMusicUrl() + "]]></MusicUrl>\n<HQMusicUrl><![CDATA[" + getHqMusicUrl()
                + "]]></HQMusicUrl>\n" + " </Music>\n</xml>");

        return sb.toString();
    }
}
