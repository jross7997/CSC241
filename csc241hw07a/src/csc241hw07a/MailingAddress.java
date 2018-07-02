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
public class MailingAddress extends Address{
    
        public MailingAddress(String s, int h, String z, String t) {
        super(s,h,z,t);
    }
    
    public String getType(){
        return "mailing";
    }
    
        @Override
    public void printInfo(Meter[] m) {
      System.out.println("Number: " + this.getNumber() + "\nStreet: " + this.getStreet()
         + "\nZip: " + this.getZipCode() + "\nType: " + this.getType() + "\nMeters:");
        for (int i = 0; i < m.length; i++) {
            if(m[i] != null){
            System.out.println("  " + m[i].getID());
        }
        }
    }


}
