package com.imooc.coupon.service;

import com.imooc.coupon.entity.CouponTemplate;
import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.CouponTemplateSDK;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author tangcj
 * @date 2023/05/01 09:26
 * 优惠券模板基础(view, delete...)服务定义
 **/
public interface ITemplateBaseService {

    /**
     * 根据优惠券模板 id 获取优惠券模板信息
     * 面向运营人员使用，返回CouponTemplate实体类
     * @param id 模板id
     * @return  {@link CouponTemplate} 优惠券模板实体
     * @throws CouponException
     */
    CouponTemplate buildTemplateInfo(Integer id) throws CouponException;

    /**
     * 查找所有可用的优惠券模板
     * 面向用户，返回 CouponTemplateSDK 不暴露部分信息
     * @return {@link CouponTemplateSDK}
     */
    List<CouponTemplateSDK> findAllUsableTemplate();

    /**
     * 获取模板 ids 到 CouponTemplateSDK 的映射
     * @param ids 模板 ids
     * @return Map<key: 模板 id， value: CouponTemplateSDK>
     */
    Map<Integer, CouponTemplateSDK> findIds2TemplateSDK(Collection<Integer> ids);
}
