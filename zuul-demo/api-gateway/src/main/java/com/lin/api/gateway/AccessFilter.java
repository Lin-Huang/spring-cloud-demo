package com.lin.api.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 过滤器的类型，它决定过滤器在请求的哪个生命周期中执行
    @Override
    public String filterType() {
        return "pre";
    }

    // 过滤器的执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 判断该过滤器是否需要被执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 过滤器的具体逻辑
    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("send:{}--{}", request.getRequestURL().toString(), request.getMethod());
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("accessToken is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        logger.info("accessToken is Ok");
        return null;
    }
}
