/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07a;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class CommercialAccount extends Account implements Constants {
    
    public CommercialAccount(String a, Customer c) {
        super(a, c);
    }
    
    public void updateBalance() {
        
        Address[] a = this.getAddresses();
        double sum = 0;

        
        for (int i = 0; i < a.length; i++) {
           // if ((a[i] instanceof House) || (a[i] instanceof Commercial)) {
                
                Meter[] m = a[i].getMeters();
                
                for (int j = 0; j < m.length; j++) {
                    
                    MeterReading[] r = m[j].getReadings();
                     double read = 0;
                    for (int k = 0; k < r.length; k++) {
                        
                        read = r[k].getReading();
                        
                        sum += read;
                    }
                    
               // }
            }
        
        this.setBalance((sum * commercialUnitRate));
        
    }
    
}
    public String getType(){
        return "commercial";
    }
    
}
