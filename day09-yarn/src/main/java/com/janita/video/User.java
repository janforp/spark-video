package com.janita.video;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * Created by Janita on 2017-05-08 22:48
 */
public class User {

    @JSONField(name = "name")
    private String username;

    @JSONField(name = "price")
    private BigDecimal money;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
