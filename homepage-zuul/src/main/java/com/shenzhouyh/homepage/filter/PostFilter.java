package com.shenzhouyh.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @description :
 * @since : 10.7.0
 */
@Component
@Slf4j
public class PostFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        Long startTime = (Long) currentContext.get("startTime");

        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        Long duration = System.currentTimeMillis() - startTime;
        log.info("URI:{}  耗时：{}ms", requestURI, duration / 100);
        return null;
    }
}
