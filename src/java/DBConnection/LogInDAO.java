/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;

import avionskakompanija.Korisnik;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.NewHibernateUtil;

/**
 *
 * @author Vladimir
 */
public class LogInDAO {
    
    private static Session session = null;
 
    public Korisnik LogIn(String username, String password){
    
        Korisnik korisnik = new Korisnik();
        session = NewHibernateUtil.getSessionFactory().openSession();

        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Korisnik.class);
            criteria.add(Restrictions.eq("username", username));
            criteria.add(Restrictions.eq("lozinka", password));
            
            korisnik = (Korisnik) criteria.uniqueResult();    
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        transaction.commit();
     
               
        return korisnik;
        
    }
      public Korisnik RegisterUser(String username, String password, String ime, String prezime, String email, String institucija, Character pol, String velicinaMajice, String linkedin, String tip){
    
        Korisnik korisnik = new Korisnik();
        session = NewHibernateUtil.getSessionFactory().openSession();
        
        Transaction transaction =  null;
        try{
            transaction = session.beginTransaction();
            
            Criteria criteria = session.createCriteria(Korisnik.class);
            criteria.add(Restrictions.eq("username", username));
            criteria.add(Restrictions.eq("password", password));
            
            korisnik = (Korisnik) criteria.uniqueResult();    
            
            if(korisnik == null){
                
                korisnik = new Korisnik();
                
                korisnik.setEmail(email);
                korisnik.setIme(ime);

                korisnik.setPol(pol);
                korisnik.setPrezime(prezime);
                korisnik.setUsername(username);
                
                session.persist(korisnik);
                transaction.commit();
            return korisnik;
                
            }else{
                return null;
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
      
        session.close();
        
        return korisnik;          
        
    }
    
}
