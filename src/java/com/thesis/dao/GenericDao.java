/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thesis.dao;

import com.thesis.model.Util;
import org.hibernate.Session;

/**
 *
 * @author acer
 */
public class GenericDao<X>  {
    public void save(X obj){
        Session ss=Util.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(obj);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void delete(X obj){
        Session ss=Util.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(obj);
        ss.getTransaction().commit();
        ss.close();
    }
    
    public void update(X obj){
        Session ss=Util.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(obj);
        ss.getTransaction().commit();
        ss.close();
    }
}
