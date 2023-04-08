package com.nitesh.hib.HibernateMVN_1;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nitesh.hib.HibernateMVN_1.entity.Products;
import com.nitesh.hib.HibernateMVN_1.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		Products pr1 = new Products(16, "toys", 20, "xyzxyz", 23.90);

		Products pr2 = new Products(17, "lappies", 10, "xxyyzzxyz", 2043.90);

		Transaction tx = null;

		try (Session ses = HibernateUtil.getSessionFactory().openSession()) {

			tx = ses.beginTransaction();

			ses.save(pr1);

			ses.save(pr2);
			

			tx.commit();

			ses.close();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();

			}

			e.printStackTrace();
		}
		
	}
}
