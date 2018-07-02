/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.time.LocalDate;

/**
 *
 * @author Justin
 */
public class Luxury extends HotelStay {
    
    public Luxury(LocalDate a,LocalDate r){
        super(a,r);
    }
    public double getPrice(){
        return 500 * (this.getDeparture().getDayOfYear() - this.getArrival().getDayOfYear());
    }
    
}
