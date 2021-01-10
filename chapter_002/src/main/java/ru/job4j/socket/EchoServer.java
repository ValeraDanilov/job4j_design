package ru.job4j.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String res = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Exit")) {
                            return;
                        }
                        if (str.contains("GET /?msg=")) {
                            res = String.format(str.substring(str.indexOf("=") + 1, str.lastIndexOf(" ")) + "%s", ".");
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    out.write(res.getBytes());
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}
