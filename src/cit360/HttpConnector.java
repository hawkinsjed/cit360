/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cit360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 * @author Yoda
 */

public class HttpConnector {
    
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.byui.edu");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            String readStream = readStream(con.getInputStream());
            // Give output for the command line
            System.out.println(readStream);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
      
            String nextLine;
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return sb.toString();
    }
    
    
}
