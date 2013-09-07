package blighkit.wechat;

import blighkit.wechat.bean.in.InMessage;
import blighkit.wechat.bean.out.OutMessage;


public interface WeChatHandle {

    /**
     * 判断是否使用当前处理器
     *
     * @param inMessage
     * @return
     */
    boolean canRun(InMessage inMessage);

    /**
     * 具体的处理逻辑
     *
     * @param inMessage
     * @return
     */
    OutMessage execute(InMessage inMessage);
}
