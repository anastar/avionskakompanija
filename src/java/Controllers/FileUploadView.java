/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DBConnection.AerodromDAO;
import DBConnection.AvionDAO;
import DBConnection.AvionskaKompanijaDAO;
import DBConnection.PosadaDAO;
import DBConnection.RadarDAO;
import avionskakompanija.Let;
import javax.faces.bean.ManagedBean;

 import java.io.IOException;
 import java.io.InputStream;
 import java.util.Scanner;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.UploadedFile;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;


@RequestScoped
@ManagedBean
public class FileUploadView {
     
    private UploadedFile file;
    private String text;

    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
       
 
    public void upload() {

        
        
        if (null != file) {
            try {
                InputStream is;
                is = file.getInputstream();
                text = new Scanner(is).useDelimiter("\\A").next();
              
                JSONObject jsonObj = new JSONObject(text);
                
                JSONArray jsonArray = jsonObj.getJSONArray("Letovi");
/*    this.idAerodrom1 = idAerodrom1;
        this.idAerodrom2 = idAerodrom2;
        this.brojLeta = brojLeta;
        this.idAviona = idAviona;
        this.trajanjeLeta = trajanjeLeta;
        this.datumPoletanja = datumPoletanja;
        this.vremePoletanja = vremePoletanja;
        this.planiranoVremeDolaskaNaDes = planiranoVremeDolaskaNaDes;
        this.ocekivanoVremeDolaskaNaDes = ocekivanoVremeDolaskaNaDes;
        this.status = status;
        this.charter = charter;
        this.stvarnoVremePoletanja = stvarnoVremePoletanja;
        this.stvDatumPol = stvDatumPol;
        this.dterm = dterm;
        this.dgate = dgate;
        this.attTerm = attTerm;
        this.attGate = attGate;
                
          "FlightNo":"JU183",
      "Air":"AirSerbia",
      "DepAP":"TIV",
      "DTerm":"TIV-Terminal 1",
      "DGate":"A1",
      "ArrAP":"BEG",
      "ATerm":"BEG-Terminal 2",
      "AGate":"A9",
      "StartDate":"01/08/2017",
      "StartTime":"03:00:00 PM",
      "Duration":"00:45",
      "RouteRadar":"{TIV,TGD,ZLA,BEG}",
      "Charter":"false",
      "IDPlane":2,
      "Crew":"{prlainovic,filipovic,nadastankovic,katarinasreckovic,tijanadimitrijevic,marij apetrovic}"        

                */ 

        boolean ubaci = true;
        AerodromDAO aerDAO = new AerodromDAO();
        AvionDAO avionDAO = new AvionDAO();
        PosadaDAO posadaDAO = new PosadaDAO();
        RadarDAO radarDAO = new RadarDAO();
        AvionskaKompanijaDAO avioKompDAO = new AvionskaKompanijaDAO();
        for(int i = 0 ; i < jsonArray.length() ; i++){

            Let let = new Let();         

            let.setBrojLeta(jsonArray.getJSONObject(i).optString("FlightNo"));
            String avioKomapnijaNaziv = jsonArray.getJSONObject(i).optString("Air");
            if(avioKompDAO.FindByName(avioKomapnijaNaziv) != null){
                let.setAir(avioKompDAO.FindIdByName(avioKomapnijaNaziv));                        
            }
            
            //da li postoji avion
            String idAviona = jsonArray.getJSONObject(i).optString("IDPlane");
            
            
           
        }


    } catch (IOException ex) {
    }
 }

}
}

