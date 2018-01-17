package com.sunnyxiaobai5.demo.rabbitmq.spring.work;

import java.io.Serializable;

public class CustomerMessage implements Serializable {

    private Long customerId;

    private Long goodsId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "CustomerMessage{" +
                "customerId=" + customerId +
                ", goodsId=" + goodsId +
                '}';
    }
}
