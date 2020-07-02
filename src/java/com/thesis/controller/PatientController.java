/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.controller;

import com.thesis.dao.PatientDao;
import com.thesis.model.Patient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.json.JSONObject;

/**
 *
 * @author acer
 */
@SessionScoped
@ManagedBean
public class PatientController {

    String msg = new String();
    
    private Patient p = new Patient();

    public Patient getP() {
        return p;
    }

    public void setP(Patient p) {
        this.p = p;
    }

    public Integer predict() {
        try {
            URL url = new URL("http://localhost:5000/prediction");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            JSONObject json = new JSONObject();
            json.put("Age", getP().getAge());
            json.put("BMI", getP().getBMI());
            json.put("Glucose", getP().getGlucose());
            json.put("Insulin", getP().getInsulin());
            json.put("HOMA", getP().getHOMA());
            json.put("Leptin", getP().getLeptin());
            json.put("Adiponectin", getP().getAdiponectin());
            json.put("Resistin", getP().getResistin());
            json.put("MCP.1", getP().getMCP());
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
                        for(char x: output.toCharArray()){
                            if(Character.toString(x).equalsIgnoreCase("0")){
                                flag = true;
                                break;
                            }
                        }
		}
                if(flag){
                    msg = "Patient is healthy";
                }else{
                    msg = "Patient is sick";
                }
                FacesContext fc=FacesContext.getCurrentInstance();
                fc.addMessage(null, new FacesMessage(msg));
                
            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }
    
    public void save(){
        getP().setState(msg);
    new PatientDao().save(getP());
    }
    
    public List<Patient> ls(){
    return new PatientDao().ls();
    }
}
