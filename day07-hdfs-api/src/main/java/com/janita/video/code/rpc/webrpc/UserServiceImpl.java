package com.janita.video.code.rpc.webrpc;

/**
 * Created by Janita on 2017-05-06 22:41
 */
public class UserServiceImpl implements IUserLoginService{


    @Override
    public String login(String name, String password) {
        return name + " logged in successfully ....";
    }
}
