/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.dao;

import com.thesis.model.Patient;
import com.thesis.model.Util;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author acer
 */
public class PatientDao extends GenericDao<Patient>{
    public List<Patient> ls(){
        Session ss=Util.getSessionFactory().openSession();
        return ss.createCriteria(Patient.class).list();
    }
}
