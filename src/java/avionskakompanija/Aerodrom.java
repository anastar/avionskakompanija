package avionskakompanija;
// Generated 31-Aug-2017 20:37:18 by Hibernate Tools 4.3.1



/**
 * Aerodrom generated by hbm2java
 */
public class Aerodrom  implements java.io.Serializable {


     private Integer idAerodrom;
     private String naziv;
     private float x;
     private float y;
     private String oznaka;

    public Aerodrom() {
    }

    public Aerodrom(String naziv, float x, float y, String oznaka) {
       this.naziv = naziv;
       this.x = x;
       this.y = y;
       this.oznaka = oznaka;
    }
   
    public Integer getIdAerodrom() {
        return this.idAerodrom;
    }
    
    public void setIdAerodrom(Integer idAerodrom) {
        this.idAerodrom = idAerodrom;
    }
    public String getNaziv() {
        return this.naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
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
    public String getOznaka() {
        return this.oznaka;
    }
    
    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }




}


