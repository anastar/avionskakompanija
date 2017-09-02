/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Radari;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author anash
 */
public class RadarDAO {
          private static Session session = null;

           public Radari FindRadarByName(String name){
    
        Radari radar = new Radari();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Radari.class);
            criteria.add(Restrictions.eq("oznaka", name));
            
            radar = (Radari) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return radar;   
    }
}
