package com.janita.video.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by Janita on 2017-04-28 15:42
 */
public class Client  {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8899);
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();

        PrintWriter writer = new PrintWriter(out);
        writer.println("hello");
        writer.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        System.out.println("*******"+reader.readLine());
    }
}
