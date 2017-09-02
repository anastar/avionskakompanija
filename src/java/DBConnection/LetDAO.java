/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Avion;
import avionskakompanija.Let;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author anash
 */
public class LetDAO {
      private static Session session = null;

    
     public Let FindAvionById(String idLet){
    
        Let let = new Let();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Let.class);
            criteria.add(Restrictions.eq("idLet", idLet));
                        
            let = (Let) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return let;   
    }
}
