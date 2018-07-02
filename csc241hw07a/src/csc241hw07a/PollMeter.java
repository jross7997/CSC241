/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07a;

/**
 *
 * @author Justin
 */
public class PollMeter extends Meter {

    public PollMeter(String id, String b, String t) {
        super(id, b, t);
    }

    public String getType() {
        return "poll";
    }

    @Override
    public void printReadings(MeterReading[] mr) {
        System.out.println("ID: " + this.getID() + "\nBrand: " + this.getBrand() + "\nLocation: " 
                + this.getLocation() + "\nType: " + this.getType() + "\nMeters Readings:");
        for (int i = 0; i < mr.length; i++) {
            if(mr[i] != null){
                System.out.println("  " + mr[i].printDate());
            }
            
        }
    }

}
