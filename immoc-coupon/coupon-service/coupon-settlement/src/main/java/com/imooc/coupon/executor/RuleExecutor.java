package com.imooc.coupon.executor;

import com.imooc.coupon.constant.RuleFlag;
import com.imooc.coupon.vo.SettlementInfo;

/**
 * @author tangcj
 * @date 2023/05/02 14:32
 * 优惠券模板规则处理器接口定义
 **/
public interface RuleExecutor {

    /**
     * 规则类型标记
     * 用于定位倒是哪种优惠
     * @return {@link RuleFlag}  规则枚举
     */
    RuleFlag ruleConfig();

    /**
     * 优惠券规则的计算
     * @param settlement {@link SettlementInfo} 包含了选择的优惠券
     * @return  {@link SettlementInfo} 修正过的结算信息
     */
    SettlementInfo computeRule(SettlementInfo settlement);

}
