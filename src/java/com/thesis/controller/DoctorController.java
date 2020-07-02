/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.controller;

import com.thesis.dao.DoctorDao;
import com.thesis.model.Doctor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author acer
 */

@ManagedBean
@SessionScoped
public class DoctorController {
    private Doctor doc = new Doctor();
      
    public Doctor getDoc() {
        return doc;
    }

    public void setDoc(Doctor doc) {
        this.doc = doc;
    }
    
    public void save(){
   new DoctorDao().save(getDoc());
    }
    
    public List<Doctor> lsdoctor(){
    return new DoctorDao().ls();
    }
}
