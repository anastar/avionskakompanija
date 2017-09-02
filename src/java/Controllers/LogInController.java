/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBConnection.LogInDAO;
import avionskakompanija.Korisnik;
import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Vladimir
 */
@ManagedBean(name = "logInController")
@SessionScoped
public class LogInController implements Serializable{

    /**
     * Creates a new instance of LogInController
     */

     private Integer idKorisnik;
     private String ime;
     private String prezime;
     private char pol;
     private Date datumRodjenja;
     private String email;
     private int avioKompanija;
     private String username;
     private String lozinka;
     private String tip;
     private boolean status;

    public LogInController(Integer idKorisnik, String ime, String prezime, char pol, Date datumRodjenja, String email, int avioKompanija, String username, String lozinka, String tip, boolean status) {
        this.idKorisnik = idKorisnik;
        this.ime = ime;
        this.prezime = prezime;
        this.pol = pol;
        this.datumRodjenja = datumRodjenja;
        this.email = email;
        this.avioKompanija = avioKompanija;
        this.username = username;
        this.lozinka = lozinka;
        this.tip = tip;
        this.status = status;
    }

    public LogInController() {
    }

    public Integer getIdKorisnik() {
        return idKorisnik;
    }

    public void setIdKorisnik(Integer idKorisnik) {
        this.idKorisnik = idKorisnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvioKompanija() {
        return avioKompanija;
    }

    public void setAvioKompanija(int avioKompanija) {
        this.avioKompanija = avioKompanija;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

     
    
    public String LogIn(){

       /* Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
        applySettings(configuration.getProperties());
        SessionFactory session = configuration.buildSessionFactory(builder.build());    */ 
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        
        Korisnik korisnik = new Korisnik();
        
        LogInDAO dataAccesLayer = new LogInDAO();
        
        if(username != null && lozinka != null){
            korisnik = dataAccesLayer.LogIn(username, lozinka);
        }        
        if(korisnik!=null && username.equals("admin")){
            return "admin";
        }
        
        if(korisnik != null){
            return "newTemplateClient";
      // return "proba";
        }
        else{
            return "index";
        }
       
    }
     public String RegisterUser(){
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession sessionss = (HttpSession) context.getExternalContext().getSession(true);
        
        Korisnik korisnik = new Korisnik();
        
        LogInDAO dataAccesLayer = new LogInDAO();
        
        if(username != null && lozinka != null){
          //  korisnik = dataAccesLayer.RegisterUser();
        }        
        if(korisnik != null){
       
        return "dashboard";
        }
        else{
            return "index";
        }
       
    }
    
    
}
