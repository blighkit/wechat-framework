package blighkit.wechat;

import blighkit.wechat.bean.in.InMessage;
import blighkit.wechat.bean.out.OutMessage;
import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class WeChatFactory {
    private static Logger log = Logger.getLogger(WeChatFactory.class);
    private static WeChatFactory instance;
    List<WeChatHandle> handles = new ArrayList<WeChatHandle>();
    private String config = "/wechat.xml";

    private WeChatFactory() {
        loadHandles();
    }

    public static WeChatFactory getInstance() {
        if (instance == null) {
            instance = new WeChatFactory();
        }
        return instance;
    }

    private void loadHandles() {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(WeChatFactory.class.getResourceAsStream(config));
            Element list = document.getRootElement();
            List<Element> elements = list.elements();
            for (Element element : elements) {
                if (element.getName().equals("bean")) {
                    Attribute className = element.attribute("class");
                    log.debug(className.getStringValue());
                    handles.add(loadClass(className.getStringValue()));
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }

    private WeChatHandle loadClass(String className) {
        try {
            Class<?> ins = Class.forName(className);
            return (WeChatHandle) ins.newInstance();
        } catch (Exception e) {
            log.error("", e);
        }
        return null;
    }

    public OutMessage handle(InMessage inMessage) {
        for (WeChatHandle handle : handles) {
            if (handle.canRun(inMessage)) {
                return handle.execute(inMessage);
            }
        }
        return null;
    }
}
