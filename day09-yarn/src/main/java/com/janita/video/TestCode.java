package com.janita.video;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by Janita on 2017-05-08 22:37
 */
public class TestCode {

    @Test
    public  void testBigDecimal() {

        String json = "{\n" +
                "    \"name\": \"janita\",\n" +
                "    \"price\": 12\n" +
                "}";
        User user = JSON.parseObject(json,User.class);

        System.out.println(user);
    }

    @Test
    public void testEq(){

        BigDecimal decimal = new BigDecimal("0.00");
        BigDecimal decimal1 = new BigDecimal(0.0);

        System.out.println(decimal.doubleValue() == decimal1.doubleValue());
    }
}
