/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public class Address {

    private String street = "", zipCode = "", houseType = "";
    private int houseNumber;
    private Account account;
    private ArrayList<Meter> meterList = new ArrayList<Meter>();

    public Address(String s, int n, String z, String t) {
        street = s;
        zipCode = z;
        houseType = t;
        houseNumber = n;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getType() {
        return houseType;
    }

    public Meter[] getMeters() {
        Meter m[] = new Meter[meterList.size()];
            m = meterList.toArray(m);
         return m;
    }

    public boolean addMeter(Meter m) {
        if (m != null) {
            meterList.add(m);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeMeter(String id) {
        Meter m1;
        for (int i = 0; i < meterList.size(); i++) {
            m1 = meterList.get(i);
            if (m1.getID().equals(id)) {
                meterList.remove(i);
                return true;
            } 
        }
        return false;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account a) {
        account = a;
    }

}
