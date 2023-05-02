package com.imooc.coupon.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author tangcj
 * @date 2023/05/01 18:15
 * Kafka相关的服务接口定义
 **/
public interface IKafkaService {

    /**
     * 消费优惠券Kafka消息
     * @param record {@link ConsumerRecord}
     */
    void consumeCouponKafkaMessage(ConsumerRecord<?, ?> record);
}
