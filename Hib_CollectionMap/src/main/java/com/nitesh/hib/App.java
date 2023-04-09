package com.nitesh.hib;


import org.hibernate.Session;
import org.hibernate.Transaction;
import com.nitesh.hib.Util.HibernateUtil;
import com.nitesh.hib.entity.Address;
import com.nitesh.hib.entity.Courses;
import com.nitesh.hib.entity.Students;



public class App 
{
    public static void main(String[] args ){
    	
    	Students st1 = new Students();
    	
    	st1.setName("Ravinder");
    	st1.setStandard("B-Tech");
    	
    	Address add1 = new Address();
    	
    	add1.setCity("Mohali");
    	add1.setStreet("Phase-6");
    	add1.setState("Punjab");
    	add1.setPinCode("321456");
    	
    	
    	Courses crs1 = new Courses();
    	crs1.setCourseName("PLC Programming");
    	crs1.setCourseDuration("2 Months");
    	crs1.setInstructor("Jayesh");
    	
    	st1.getAddr().add(add1);
    	st1.getCrs().add(crs1);
    	
    	
    	Address add2 = new Address();
    	
    	add2.setCity("Baddi");
    	add2.setStreet("Phase-11");
    	add2.setState("Himanchal Pradesh");
    	add2.setPinCode("345212");
    	    	
    	Courses crs2 = new Courses();
    	crs2.setCourseName("Java Programming");
    	crs2.setCourseDuration("3 Months");
    	crs2.setInstructor("Pradeep");
    	
    	st1.getAddr().add(add2);
    	st1.getCrs().add(crs2);
    	
    	Session ses = HibernateUtil.getSessionFactory().openSession();
    	
    	//SessionFactory sesFact = new Configuration().configure().buildSessionFactory();
    	
    	//Session ses = sesFact.openSession();
    	
    	Transaction tx = ses.beginTransaction();
    	
    	
    	ses.persist(st1);
    	
    	
    	
    	tx.commit();
    	ses.close();
    }
}
