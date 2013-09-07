package com.hml520.handle;

import blighkit.wechat.WeChatHandle;
import blighkit.wechat.bean.in.InMessage;
import blighkit.wechat.bean.out.OutMessage;
import blighkit.wechat.bean.out.TextOutMessage;

public class WelcomeHandle implements WeChatHandle {

    @Override
    public boolean canRun(InMessage inMessage) {
        return true;
    }

    @Override
    public OutMessage execute(InMessage inMessage) {
        TextOutMessage outMessage = new TextOutMessage(inMessage);
        outMessage.setContent("你好！");
        return outMessage;
    }


}
