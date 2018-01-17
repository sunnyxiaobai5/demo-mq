package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "haixue.mq")
public class MessageProperties {

    private String hxExchangeName;

    private String orderGoodsRecordQueueName;

    private String orderGoodsRecordQueueRoutingKey;

    public String getHxExchangeName() {
        return hxExchangeName;
    }

    public void setHxExchangeName(String hxExchangeName) {
        this.hxExchangeName = hxExchangeName;
    }

    public String getOrderGoodsRecordQueueName() {
        return orderGoodsRecordQueueName;
    }

    public void setOrderGoodsRecordQueueName(String orderGoodsRecordQueueName) {
        this.orderGoodsRecordQueueName = orderGoodsRecordQueueName;
    }

    public String getOrderGoodsRecordQueueRoutingKey() {
        return orderGoodsRecordQueueRoutingKey;
    }

    public void setOrderGoodsRecordQueueRoutingKey(String orderGoodsRecordQueueRoutingKey) {
        this.orderGoodsRecordQueueRoutingKey = orderGoodsRecordQueueRoutingKey;
    }
}
