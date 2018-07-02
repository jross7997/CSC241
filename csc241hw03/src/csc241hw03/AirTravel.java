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
public abstract class AirTravel {
    private String airline;
    private LocalDate departureDate,returnDate;
    
    public AirTravel(String a, LocalDate d, LocalDate r){
        airline = a;
        departureDate = d;
        returnDate = r;
    }
    public abstract double getPrice();
}
