package blighkit.wechat.bean.out;

import blighkit.wechat.bean.in.InMessage;

public class TextOutMessage extends OutMessage {
	private String content;

	public TextOutMessage(InMessage inMessage) {
		super(inMessage);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
        sb.append("</CreateTime>\n<MsgType><![CDATA[text]]></MsgType>\n<Content><![CDATA[");
        sb.append(getContent());
        sb.append("]]></Content>\n</xml>");
        return sb.toString();
    }
}
