/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.dao;

import com.thesis.model.Doctor;
import com.thesis.model.Util;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author acer
 */
public class DoctorDao extends GenericDao<Doctor>{
    public List<Doctor> ls(){
        Session ss=Util.getSessionFactory().openSession();
        return ss.createCriteria(Doctor.class).list();
    }
    
}
