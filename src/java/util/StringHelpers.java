/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anash
 */
public class StringHelpers {
    
    
    public Date convertStringToDate(String date){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
        Date startDate = new Date();
        try {
            startDate = df.parse(date);
            String newDateString = df.format(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return startDate;        
    }
    
}
