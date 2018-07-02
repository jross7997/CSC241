/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw03;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Justin
 */
public class VacationPackage {

    private LocalDate arrivalDate, departureDate;
    private Guest guest;
    private AirTravel air;
    private HotelStay hotel;

    public VacationPackage(LocalDate a, LocalDate d) {
        arrivalDate = a;
        departureDate = d;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest g1) {
        guest = g1;
    }

    public AirTravel getAirTravel() {
        return air;
    }

    public void setAirTravel(AirTravel a1) {
        air = a1;
    }

    public HotelStay getHotelStay() {
        return hotel;
    }

    public void setHotelStay(HotelStay h1) {

        hotel = h1;
    }

    public int getLengthOfStay() {
        int days = departureDate.getDayOfYear() - arrivalDate.getDayOfYear();
        return days;
    }

    public double getPrice() {
        if ((air != null) && (hotel != null)) {
            if (guest instanceof Adult) {
                return air.getPrice() + hotel.getPrice() + 100 * this.getLengthOfStay();
            } else {
                return air.getPrice() + hotel.getPrice() + 25 * this.getLengthOfStay();
            }
        } else {
            return 0;
        }
    }
}
