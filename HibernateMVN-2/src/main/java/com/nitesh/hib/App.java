package com.nitesh.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nitesh.hib.entity.Games;

public class App 
{
    public static void main( String[] args ){
    	
    	Games gm = new Games(12, "Outdoor", "just fun", 2);
    	
    	
    	SessionFactory ssfact = new Configuration().configure().buildSessionFactory();
    	Session ses = ssfact.openSession();
    	ses.beginTransaction();
    	ses.persist(gm);
    	ses.getTransaction().commit();
    	ses.close();
    	
    	
    	ses = ssfact.openSession();
    	ses.beginTransaction();
    	gm = (Games) ses.get(Games.class, 12);
    	System.out.println("Type of game is : "+gm.getGameType()+" and name of game is : "+gm.getGameName());
    	
    	
    	
    }
    
}
