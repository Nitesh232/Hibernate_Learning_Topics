package com.nitesh.hib;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nitesh.hib.entity.Students;

public class App 
{
    public static void main( String[] args ) throws IOException{
    	
    	SessionFactory sesFact = new Configuration().configure().buildSessionFactory();

    	Students st = new Students();
    	
    	st.setCity("Pune");
    	st.setName("Jayesh");
    	st.setStreet("Pimpari");
    	st.setX(123.456);    	
    	
    	st.setVedio(Files.readAllBytes(Paths.get("D://files//9b2bab531e4a451d849b9f036c658630.mp4")));
    	
    	st.setFile(Files.readAllBytes(Paths.get("D://files//temp//test.txt")));
    	
    	Session ses = sesFact.openSession();
    	Transaction tx =  ses.beginTransaction();
    	
    	ses.persist(st);
    	
    	
    	tx.commit();
    	
    	ses.close();
    	
    	
    	
    	ses = sesFact.openSession();
    	tx =  ses.beginTransaction();
    	
    	Students stFetched = ses.find(Students.class, st.getId());
    	
		//Assertions.assertNotNull(stFetched.getVedio());

    	byte[] cover = stFetched.getVedio();

    	//Saving the fetched file to defined directory 
    	try (FileOutputStream fos
    	       = new FileOutputStream("D://V2//testBook.mp4")) {
    	fos.write(cover);
    	} catch (Exception e) {
    	   e.printStackTrace();
    	}
    	
    	
    	
    }
    
}
