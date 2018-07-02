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
public abstract class HotelStay {
    private LocalDate arrivaldate, departuredate;
    
    public HotelStay(LocalDate a, LocalDate d){
        arrivaldate = a;
        departuredate = d;
    }
    
    public abstract double getPrice();
    
    public LocalDate getArrival(){
        return arrivaldate;
    }
    
    public LocalDate getDeparture(){
        return departuredate;
    }
    
}
