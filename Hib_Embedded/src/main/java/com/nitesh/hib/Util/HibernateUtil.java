package com.nitesh.hib.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static StandardServiceRegistry reg;
	private static SessionFactory session;
	
	public static SessionFactory getSessionFactory() {
		
		if(session == null) {
			
			try {
				
				reg = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
				MetadataSources source = new MetadataSources(reg);	
				
				Metadata meta = source.getMetadataBuilder().build();
				
				session = meta.getSessionFactoryBuilder().build();
								
				
			} catch (Exception e) {
				e.printStackTrace();
				
				if(reg != null) {
					StandardServiceRegistryBuilder.destroy(reg);
				}
			}			
			
		}
		
		
		return session;	
	}

}
