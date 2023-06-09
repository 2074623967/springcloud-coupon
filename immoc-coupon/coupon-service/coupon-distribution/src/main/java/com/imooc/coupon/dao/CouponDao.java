package com.imooc.coupon.dao;

import com.imooc.coupon.constant.CouponStatus;
import com.imooc.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author tangcj
 * @date 2023/05/01 18:08
 * Coupon Dao接口定义
 **/
public interface CouponDao extends JpaRepository<Coupon, Integer> {

    /**
     * 根据userId + 状态寻找优惠券记录
     * @param userId
     * @param status
     * @return
     */
    List<Coupon> findAllByUserIdAndStatus(Long userId, CouponStatus status);
}
