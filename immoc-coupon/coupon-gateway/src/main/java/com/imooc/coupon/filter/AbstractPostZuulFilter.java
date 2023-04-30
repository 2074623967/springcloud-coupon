package com.imooc.coupon.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @author tangcj
 * @date 2023/04/30 10:37
 * 用于定于post类型的过滤器
 * 以后实现post类型的过滤器只需要继承AbstractPostZuulFilter这个抽象类
 **/
public abstract class AbstractPostZuulFilter extends AbstractZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

}