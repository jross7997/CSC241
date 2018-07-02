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
public class Coach extends AirTravel{
    public Coach(String a, LocalDate d, LocalDate r){
        super(a,d,r);
    }
    
        public double getPrice(){
        return 300;
    }
}
