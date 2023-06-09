package com.imooc.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author tangcj
 * @date 2023/05/01 18:20
 * 优惠券 kafka 消息对象定义
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponKafkaMessage {

    /** 优惠券状态 */
    private Integer status;

    /** Coupon 主键 */
    private List<Integer> ids;
}
