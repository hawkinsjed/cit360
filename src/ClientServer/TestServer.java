/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Yoda
 */
public class TestServer {
    
        public static void main(String[] args) throws IOException {
        try (ServerSocket listener = new ServerSocket(9090)) {
            while (true) {
                try (Socket socket = listener.accept()) {
                    PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                    out.println("Connection to server succeeded");
                }
            }
        }
    }
       
}
