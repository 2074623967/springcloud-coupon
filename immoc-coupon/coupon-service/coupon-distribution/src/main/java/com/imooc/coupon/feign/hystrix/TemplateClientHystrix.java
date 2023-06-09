package com.imooc.coupon.feign.hystrix;

import com.imooc.coupon.feign.TemplateClient;
import com.imooc.coupon.vo.CommonResponse;
import com.imooc.coupon.vo.CouponTemplateSDK;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author tangcj
 * @date 2023/05/01 18:36
 * 优惠券模板 Feign 接口的熔断降级策略
 **/
@Slf4j
@Component
public class TemplateClientHystrix implements TemplateClient {

    /**
     * 查找所有可用的优惠券模板
     * @return
     */
    @Override
    public CommonResponse<List<CouponTemplateSDK>> findAllUsableTemplate() {

        log.error("[coupon-template] findAllUsableTemplate " + "request error");
        return new CommonResponse<>(-1, "[coupon-template] request error", Collections.emptyList());
    }

    /**
     * 获取模板 ids 到 CouponTemplateSDK 的映射
     * @param ids 优惠券模板 id
     * @return
     */
    @Override
    public CommonResponse<Map<Integer, CouponTemplateSDK>> findIds2TemplateSDK(Collection<Integer> ids) {

        log.error("[coupon-template] findIds2TemplateSDK" + "request error");

        return new CommonResponse<>(-1, "[coupon-template] request error", new HashMap<>());
    }
}
