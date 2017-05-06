package com.janita.video.code.rpc;

/**
 * Created by Janita on 2017-05-06 22:23
 */
public interface ClientNameNodeProtocol {

    /**
     * 若用Long则会报错
     */
    public static final long versionID = 1L;

    String getMetaData(String path);
}
