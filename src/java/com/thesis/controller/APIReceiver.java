/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.controller;

import com.thesis.model.Patient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

/**
 *
 * @author acer
 */
public class APIReceiver {

    public static void main(String[] args) throws ClientProtocolException, IOException {

        try {
            URL url = new URL("http://localhost:5000/prediction");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject json = new JSONObject();
            json.put("Age", 48);
            json.put("BMI", 23.5);
            json.put("Glucose", 70);
            json.put("Insulin", 2.707);
            json.put("HOMA", 0.467409);
            json.put("Leptin", 8.8071);
            json.put("Adiponectin", 9.7024);
            json.put("Resistin", 7.99585);
            json.put("MCP.1", 417.114);
            System.out.println(json.toString());
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            boolean flag = false;
            while ((output = br.readLine()) != null) {
                for (char x : output.toCharArray()) {
                    if (Character.toString(x).equalsIgnoreCase("0")) {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
