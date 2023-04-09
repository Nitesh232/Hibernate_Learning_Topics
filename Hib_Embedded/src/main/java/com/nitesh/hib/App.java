package com.nitesh.hib;

import org.hibernate.Session;

import com.nitesh.hib.Util.HibernateUtil;
import com.nitesh.hib.entity.Address;
import com.nitesh.hib.entity.Courses;
import com.nitesh.hib.entity.Students;

import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args ){
    	
    	Students st1 = new Students();
    	
    	st1.setName("Ravinder");
    	st1.setStandard("B-Tech");
    	
    	Address add1 = new Address();
    	add1.setCity("Mohali");
    	add1.setStreet("Phase-06");
    	add1.setState("Punjab");
    	add1.setPinCode("415243");
    	
    	Courses crs = new Courses();
    	crs.setCourseName("PLC Programming");
    	crs.setCourseDuration("3 Months");
    	crs.setInstructor("Jayesh");    	
    	
    	
    	st1.setAddr(add1);
    	st1.setCrs(crs);
    	
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	
    	Transaction tx = ses.beginTransaction();
    	
    	ses.persist(st1);
    	
    	
    	tx.commit();
    	ses.close();   	
    
    }
}
