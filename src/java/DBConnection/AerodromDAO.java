/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Aerodrom;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author anash
 */
public class AerodromDAO {
     private static Session session = null;
 
    public Aerodrom FindAerodromByName(String name){
    
        Aerodrom aerodrom = new Aerodrom();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Aerodrom.class);
            criteria.add(Restrictions.eq("naziv", name));
                        
            aerodrom = (Aerodrom) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return aerodrom;   
            
    }
    
    public Aerodrom CheckIfExistsByNameTermGate(String name, String terminal, String gate){
        
        Aerodrom aerodrom = new Aerodrom();
        session = NewHibernateUtil.getSessionFactory().openSession();
            
        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Aerodrom.class);
            criteria.add(Restrictions.eq("naziv", name));
                        
            aerodrom = (Aerodrom) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return aerodrom;   
    
    }
}
