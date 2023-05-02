package com.imooc.coupon.service;

import com.imooc.coupon.entity.Coupon;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.AcquireTemplateRequest;
import com.imooc.coupon.vo.CouponTemplateSDK;
import com.imooc.coupon.vo.SettlementInfo;

import java.util.List;

/**
 * @author tangcj
 * @date 2023/05/01 18:26
 * 用户服务相关的接口定义
 *  1. 用户三类状态优惠券信息展示服务
 *  2. 查看用户当前可以领取的优惠券模板 - coupon-template微服务配合实现
 *  3. 用户领取优惠券服务
 *  4. 用户消费优惠券服务 - coupon-settlement 微服务配合实现
 **/
public interface IUserService {

    /**
     * 根据用户id和状态查询优惠券记录(三类状态信息)
     * @param userId 用户id
     * @param status 优惠券状态
     * @return {@link Coupon}
     * @throws CouponException
     */
    List<Coupon> findCouponsByStatus(Long userId, Integer status) throws CouponException;

    /**
     * 根据用户id查找当前可以领取的优惠券模板
     * @param userId 用户id
     * @return  {@link CouponTemplateSDK}
     * @throws CouponException
     */
    List<CouponTemplateSDK> findAvailableTemplate(Long userId) throws CouponException;

    /**
     * 用户领取优惠券
     * @param request {@link AcquireTemplateRequest}
     * @return {@link Coupon}
     * @throws CouponException
     */
    Coupon acquireTemplate(AcquireTemplateRequest request) throws CouponException;

    /**
     * 结算(核销)优惠券
     * @param info {@link SettlementInfo}  传递用户id、商品信息、优惠券 并没有传递金额
     * @return {@link SettlementInfo}      返回用户id、商品信息、优惠券、结算金额等信息
     * SettlementInfo.employ标识了是核销还是结算
     * */
    SettlementInfo settlement(SettlementInfo info) throws CouponException;
}
