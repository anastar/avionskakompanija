/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Avionskakompanija;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author anash
 */
public class AvionskaKompanijaDAO {
    
    private static Session session = null;

    
     public Avionskakompanija FindByName(String name){
    
        Avionskakompanija kompanija = new Avionskakompanija();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Avionskakompanija.class);
            criteria.add(Restrictions.eq("naziv", name));
            
            kompanija = (Avionskakompanija) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return kompanija;   
    }
     
     
     
     
     public int FindIdByName(String name){
            
            session = NewHibernateUtil.getSessionFactory().openSession();
            int id = -1;
            Transaction transaction =  null;

        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Avionskakompanija.class);
            criteria.add(Restrictions.eq("naziv", name));
            
            Avionskakompanija avioKomp = (Avionskakompanija)criteria.uniqueResult();    
            id = avioKomp.getIdAvioKompanije();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
     
     return id;
     }
}
