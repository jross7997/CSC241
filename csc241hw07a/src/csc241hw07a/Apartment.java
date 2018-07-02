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
public class Apartment extends Address {

    private String unit;

    public Apartment(String s, int n, String z, String t, String u) {
        super(s, n, z, t);
        unit = u;
    }

    public String getType() {
        return "apartment";
    }

    public void setUnit(String u) {
        unit = u;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public void printInfo(Meter[] m) {
      System.out.println("Number: " + this.getNumber() + "\nStreet: " + this.getStreet()
         + "\nZip: " + this.getZipCode() + "\nType: " + this.getType() + "\nUnit: " + unit + "\nMeters:");
        for (int i = 0; i < m.length; i++) {
            if(m[i] != null){
            System.out.println("  " + m[i].getID());
        }
        }
    }
}
