package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "haixue.mq")
public class MQProperties {

    private String hxExchangeName;

    private String orderGoodsRecordQueueName;

    private String orderGoodsRecordRoutingKey;

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

    public String getOrderGoodsRecordRoutingKey() {
        return orderGoodsRecordRoutingKey;
    }

    public void setOrderGoodsRecordRoutingKey(String orderGoodsRecordRoutingKey) {
        this.orderGoodsRecordRoutingKey = orderGoodsRecordRoutingKey;
    }
}
