package com.imooc.coupon.converter;

import com.imooc.coupon.constant.CouponStatus;

import javax.persistence.AttributeConverter;

/**
 * @author tangcj
 * @date 2023/05/01 17:47
 * 优惠券状态枚举属性转换器
 **/
public class CouponStatusConverter implements AttributeConverter<CouponStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return couponStatus.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.of(code);
    }
}
