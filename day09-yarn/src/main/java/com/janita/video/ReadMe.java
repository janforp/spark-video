package com.janita.video;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Janita on 2017-05-09 23:11
 */
public class ReadMe {
    /**
     * day09的04视频学完
     */


    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        User user = null;

        for (int i=0;i<4;i++){
            user = new User();
            user.setMoney(new BigDecimal(i));
            user.setUsername("xm " +i);

            users.add(user);

        }
        System.out.print(users);
    }
}
