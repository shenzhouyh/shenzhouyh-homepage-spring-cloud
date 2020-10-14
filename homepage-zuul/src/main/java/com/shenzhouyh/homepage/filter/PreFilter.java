package com.shenzhouyh.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * @description :
 * @since : 10.7.0
 */
@Component
public class PreFilter extends ZuulFilter {
    /**
     * 过滤类型
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤的优先级，数字越小，优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.set("startTime", System.currentTimeMillis());
        return null;
    }
}
