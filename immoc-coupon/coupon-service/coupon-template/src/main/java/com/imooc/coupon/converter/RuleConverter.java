package com.imooc.coupon.converter;

import com.alibaba.fastjson.JSON;
import com.imooc.coupon.vo.TemplateRule;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author tangcj
 * @date 2023/04/30 21:54
 * 优惠券规则属性转换器
 **/
@Converter
public class RuleConverter implements AttributeConverter<TemplateRule, String> {

    @Override
    public String convertToDatabaseColumn(TemplateRule templateRule) {
        //序列化成json对象用于存储到数据库
        return JSON.toJSONString(templateRule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        //数据库中的数据反序列化成对象
        return JSON.parseObject(rule, TemplateRule.class);
    }
}