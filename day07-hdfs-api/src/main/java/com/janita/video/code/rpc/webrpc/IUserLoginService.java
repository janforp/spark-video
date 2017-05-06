package com.janita.video.code.rpc.webrpc;

/**
 * Created by Janita on 2017-05-06 22:41
 */
public interface IUserLoginService {

    public static final long versionID  = 100L;

    String login(String name,String password);
}
