package avionskakompanija;
// Generated 31-Aug-2017 20:37:18 by Hibernate Tools 4.3.1



/**
 * Radari generated by hbm2java
 */
public class Radari  implements java.io.Serializable {


     private Integer idRadar;
     private String naziv;
     private String oznaka;
     private float x;
     private float y;

    public Radari() {
    }

    public Radari(String naziv, String oznaka, float x, float y) {
       this.naziv = naziv;
       this.oznaka = oznaka;
       this.x = x;
       this.y = y;
    }
   
    public Integer getIdRadar() {
        return this.idRadar;
    }
    
    public void setIdRadar(Integer idRadar) {
        this.idRadar = idRadar;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    public String getOznaka() {
        return this.oznaka;
    }
    
    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }
    public float getX() {
        return this.x;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return this.y;
    }
    
    public void setY(float y) {
        this.y = y;
    }




}

