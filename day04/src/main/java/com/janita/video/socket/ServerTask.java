package com.janita.video.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Janita on 2017-04-28 15:51
 */
public class ServerTask implements Runnable {

    private Socket socket;

    public ServerTask(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream out = socket.getOutputStream();
            /**
             * 从网络通信输入流中读取客户端发送的数据
             * 注意：读数据的方法是阻塞的
             */
            String param = reader.readLine();
            String result = new GetDataServiceImpl().getData(param);
            PrintWriter writer = new PrintWriter(out);
            writer.print(result);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
