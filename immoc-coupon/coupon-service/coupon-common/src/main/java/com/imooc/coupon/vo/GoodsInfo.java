package com.imooc.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tangcj
 * @date 2023/05/01 18:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo {

    /** 商品类型 */
    private Integer type;
    /** 商品价格 */
    private Double price;
    /** 商品数量 */
    private Integer count;

    // TODO 商品名称、使用信息等等
}