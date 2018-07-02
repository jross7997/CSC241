/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.time.LocalDateTime;

/**
 *
 * @author Justin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Address a1 = new Address("1",1,"1","1");
        Meter m = new Meter("i","j","k");
        a1.addMeter(m);
        System.out.println(a1.getMeters());
        a1.removeMeter("i");
        System.out.println(a1.getMeters());      
    }
    
}
