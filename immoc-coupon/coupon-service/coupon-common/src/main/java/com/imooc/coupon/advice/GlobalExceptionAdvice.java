package com.imooc.coupon.advice;

import com.imooc.coupon.exception.CouponException;
import com.imooc.coupon.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangcj
 * @date 2023/04/30 16:16
 * 全局异常处理
 **/
@RestControllerAdvice
public class GlobalExceptionAdvice {

    /**
     * 对 CouponException 进行统一处理
     * @param ex CouponException捕获之后抛出的异常
     */
    //异常处理器：对指定的异常进行拦截
    @ExceptionHandler(value = CouponException.class)
    public CommonResponse<String> handlerCouponException(HttpServletRequest req, CouponException ex) {
        CommonResponse<String> response = new CommonResponse<>(-1, "business error");
        response.setData(ex.getMessage());
        return response;
    }
}
