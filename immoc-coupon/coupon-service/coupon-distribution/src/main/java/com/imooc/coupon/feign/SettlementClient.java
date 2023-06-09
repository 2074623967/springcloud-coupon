package com.imooc.coupon.feign;

import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.feign.hystrix.SettlementClientHystrix;
import com.imooc.coupon.vo.CommonResponse;
import com.imooc.coupon.vo.SettlementInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author tangcj
 * @date 2023/05/01 18:29
 * 优惠券结算微服务 Feign 接口定义
 **/
@FeignClient(value = "coupon-settlement", fallback = SettlementClientHystrix.class)
public interface SettlementClient {

    @RequestMapping(value = "/settlement/settlement/compute", method = RequestMethod.POST)
    CommonResponse<SettlementInfo> computeRule(@RequestBody SettlementInfo settlement) throws CouponException;
}
