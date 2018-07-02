/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

/**
 *
 * @author Justin
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        

         
         Adult adl = new Adult("Jones", "Cosby");
         System.out.println(adl.getFullName());
         
         Child chl = new Child("Jones", "Derby");
         System.out.println(chl.getFullName());
         
         Luxury l1 = new Luxury(LocalDate.now(), LocalDate.now().plus(5,ChronoUnit.DAYS));
         System.out.println(l1.getPrice());
         
         Economy e1 = new Economy(LocalDate.now(), LocalDate.now().plus(5,ChronoUnit.DAYS));
         System.out.println(e1.getPrice());
         
         FirstClass f1 = new FirstClass("Jet Blue",LocalDate.now(),LocalDate.now().plus(5,ChronoUnit.DAYS));
         System.out.println(f1.getPrice());
         
         Coach c1 = new Coach("Not 9/11",LocalDate.now(),LocalDate.now().plus(5,ChronoUnit.DAYS));
         System.out.println(c1.getPrice());
         
         VacationPackage vac = new VacationPackage(LocalDate.now(),LocalDate.now().plus(5, ChronoUnit.DAYS));
         System.out.println(vac.getLengthOfStay());
         
         vac.setAirTravel(c1);
         System.out.println(vac.getAirTravel());
         
//         vac.setAirTravel(f1);
//         System.out.println(vac.getAirTravel());
         
//         vac.setHotelStay(e1);
//         System.out.println(vac.getHotelStay());
         
//         vac.setHotelStay(l1);
//         System.out.println(vac.getHotelStay());
//         
           vac.setGuest(chl);

//         vac.setGuest(adl);
         System.out.println(vac.getGuest());
         System.out.println(vac.getPrice());
         
    }
    
}
