package com.imooc.coupon.exception;

/**
 * @author tangcj
 * @date 2023/04/30 16:17
 * Coupon通用异常定义
 **/
public class CouponException extends Exception {
    /**
     * @param message 传入的异常信息
     */
    public CouponException(String message) {
        //异常信息跑到Exception
        super(message);
    }
}
