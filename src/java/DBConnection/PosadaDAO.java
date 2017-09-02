/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Korisnik;
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
public class PosadaDAO {
    
    private static Session session = null;

    
    public Korisnik FindByNameAndSurname(String ime, String prezime){
    
        Korisnik korisnik = new Korisnik();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Korisnik.class);
            criteria.add(Restrictions.eq("ime", ime));
            criteria.add(Restrictions.eq("prezime",prezime));
            
            korisnik = (Korisnik) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
        return korisnik;   
    }
}
