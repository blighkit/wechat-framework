package com.hml520.handle;

import blighkit.wechat.WeChatHandle;
import blighkit.wechat.bean.in.InMessage;
import blighkit.wechat.bean.in.SubscribeInMessage;
import blighkit.wechat.bean.out.OutMessage;
import blighkit.wechat.bean.out.TextOutMessage;

public class SubscribeHandle implements WeChatHandle {


    @Override
    public boolean canRun(InMessage inMessage) {
        return inMessage instanceof SubscribeInMessage;
    }

    @Override
    public OutMessage execute(InMessage inMessage) {
        TextOutMessage outMessage = new TextOutMessage(inMessage);
        outMessage.setContent("欢迎关注我！");
        return outMessage;
    }


}
