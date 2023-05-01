package com.imooc.coupon.service;

import com.imooc.coupon.entity.CouponTemplate;

/**
 * @author tangcj
 * @date 2023/04/30 22:48
 * 异步服务接口定义
 **/
public interface IAsyncService {

    /**
     * 根据模板异步地创建优惠券码
     * @param couponTemplate {@link CouponTemplate} 优惠券模板实体
     */
    void asyncConstructCouponByTemplate(CouponTemplate couponTemplate);
}