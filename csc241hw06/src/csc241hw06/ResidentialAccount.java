/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class ResidentialAccount extends Account implements Constants {

    private ArrayList<MeterReading> reading = new ArrayList<MeterReading>();

    public ResidentialAccount(String a, Customer c) {
        super(a, c);
    }

    public void updateBalance() {
        
        Address[] a = this.getAddresses();
        double sum = 0;
        double read = 0;
        
        for (int i = 0; i < a.length; i++) {
            if ((a[i] instanceof House) || (a[i] instanceof Apartment)) {
                
                Meter[] m = a[i].getMeters();
                
                for (int j = 0; j < m.length; j++) {
                    
                    MeterReading[] r = m[j].getReadings();
                    
                    for (int k = 0; k < r.length; k++) {
                        
                        read = r[k].getReading();
                        
                        sum += read;
                    }
                    
                }
            }
        }
        this.setBalance((sum * residentialUnitRate));
        
    }
        public String getType(){
        return "residential";
    }

}
