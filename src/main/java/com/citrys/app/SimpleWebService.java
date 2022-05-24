package com.citrys.app;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


class SimpleWebService {
    private int port;

    SimpleWebService(int p) {
        port = p;
    }

    void startServer() {
        {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                while (true) {
                    Socket client = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(client.getOutputStream());
                    out.print("HTTP/1.1 200 \r\n"); // Version & status code
                    out.print("Content-Type: text/plain\r\n"); // The type of data
                    out.print("Connection: close\r\n"); // Will close stream
                    out.print("\r\n"); // End of headers
                    String line;
                    while ((line = in.readLine()) != null) {
                        if (line.length() == 0)
                            break;
                        out.print(line + "\r\n");
                        out.print("Hello World");
                    }
                    out.print("Hello World");
                    out.close();
                    in.close();
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
