package blighkit.wechat;

import blighkit.wechat.bean.in.*;
import blighkit.wechat.bean.out.OutMessage;
import blighkit.wechat.util.MessageType;
import blighkit.wechat.util.Tools;
import org.apache.log4j.Logger;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class WeChatHelper {
    private static Logger log = Logger.getLogger(WeChatHelper.class);

    public static void handle(HttpServletRequest request, HttpServletResponse response, String token) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");


        //判断是否来自微信接口
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        if (signature == null || timestamp == null || nonce == null
                || !Tools.checkSignature(token, signature, timestamp, nonce)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Boolean isGet = "get".equalsIgnoreCase(request.getMethod());
        if (isGet) {
            //如果是验证的请求，直接返回echostr的内容
            response.setContentType("text/plain");
            response.getWriter().write(request.getParameter("echostr"));
        } else {
            //获得微信接口post过来的xml数据
            ServletInputStream in = request.getInputStream();
            String xml = Tools.inputStream2String(in);
            log.debug(xml);

            //对xml数据进行处理
            InMessage inMessage = getInMessage(Tools.xml2Map(xml));
            if (inMessage == null) return;

            OutMessage outMessage = WeChatFactory.getInstance().handle(inMessage);
            if (outMessage == null) return;
            log.debug(outMessage);

            //并输出返回结果.
            response.setContentType("text/xml");
            response.getWriter().write(outMessage.toString());
        }

    }

    public static InMessage getInMessage(Map<String, String> msg) {
        if (msg == null) return null;
        InMessage inMessage = null;

        String type = msg.get("MsgType");

        if (MessageType.TEXT.equals(type)) {
            inMessage = new TextInMessage(msg.get("Content"));
        }
        if (MessageType.EVENT.equals(type)) {
            if (MessageType.SUBSCRIBE.equals(msg.get("Event"))) {
                inMessage = new SubscribeInMessage();
            } else if (MessageType.UNSUBSCRIBE.equals(msg.get("Event"))) {
                inMessage = new UnSubscribeInMessage();
            } else {
                inMessage = new ClickInMessage(msg.get("EventKey"));
            }
        }
        if (MessageType.IMAGE.equals(type)) {
            inMessage = new ImageInMessage(msg.get("PicUrl"));
        }
        if (MessageType.VOICE.equals(type)) {
            inMessage = new VoiceInMessage(msg.get("MediaId"),
                    msg.get("Format"), msg.get("Recognition"));
        }
        if (MessageType.VOICE.equals(type)) {
            inMessage = new LinkInMessage(msg.get("Title"),
                    msg.get("Description"), msg.get("Url"));
        }

        if (MessageType.LOCATION.equals(type)) {
            inMessage = new LocationInMessage(msg.get("Location_X"),
                    msg.get("Location_Y"), Long.parseLong(msg.get("Scale")),
                    msg.get("Label"));
        }
        if (inMessage != null) {
            inMessage.setFromUserName(msg.get("FromUserName"));
            inMessage.setToUserName(msg.get("ToUserName"));
            inMessage.setMsgId(msg.get("MsgId"));
            inMessage.setMsgType(msg.get("MsgType"));
            inMessage.setCreateTime(Long.parseLong(msg.get("CreateTime")));
        }
        return inMessage;
    }

}
