package com.bepop.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bepop.model.Consultoria;
import com.bepop.util.HibernateUtil;

public class ConsultoriaDAO {
	
	
	
	public void salvar(Consultoria consultoria) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(consultoria); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
	}
	
	public void atualizar(Consultoria consultoria) {
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(consultoria);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
	}
	
	public void excluir(Consultoria consultoria) {
	        Transaction transaction = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            transaction = session.beginTransaction();
	            session.delete(consultoria);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	 
	 public List<Consultoria> buscarPorCnpj(String cnpj){
		 
		 try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			 	List<Consultoria> listaConsutoria = session.createQuery("from Consultoria a where a.cnpj = :cnpj", Consultoria.class).setParameter("cnpj", cnpj).list();
	            return listaConsutoria;
	        }
		 
	 }
	
}
