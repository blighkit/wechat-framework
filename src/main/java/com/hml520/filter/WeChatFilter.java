package com.hml520.filter;

import blighkit.wechat.WeChatHelper;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WeChatFilter implements Filter {
    private static Logger log = Logger.getLogger(WeChatFilter.class);
    String token = "blighkit";

    @Override
    public void destroy() {
        log.info("WeChatFilter destroy");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        WeChatHelper.handle(request,response,token);

    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("WeChatFilter init");
    }

}
