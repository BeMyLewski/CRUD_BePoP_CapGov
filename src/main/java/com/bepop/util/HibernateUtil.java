package com.bepop.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	

	private static SessionFactory buildSessionFactory() {
		try {
            Configuration configuration = new Configuration().configure();
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Falha ao criar a SessionFactory inicial." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
	
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
	public static void shutdown() {
        getSessionFactory().close();
    }
	
	
}
