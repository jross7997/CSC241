/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public abstract class Meter {

    private String id, brand, notes, type;
    private Address address;
    private ArrayList<MeterReading> readingArray = new ArrayList<MeterReading>();

    public Meter(String i, String b, String t) {
        id = i;
        brand = b;
        type = t;
    }

    public String getID() {
        return id;
    }

    public MeterReading[] getReadings() {
        MeterReading list[] = new MeterReading[readingArray.size()];
        list = readingArray.toArray(list);
        return list;
    }

    public MeterReading getCurrentReading() {
        MeterReading m;
        if (readingArray.isEmpty()) {
            m = null;
        } else {
            m = readingArray.get(readingArray.size() - 1);
        }
        return m;
    }

    public boolean addReading(MeterReading m) {
        if (m != null) {
            readingArray.add(m);
            return true;
        } else {
            return false;
        }
    }

    public String getBrand() {
        return brand;
    }

    public abstract String getType();

    public String getLocation() {
        return notes;
    }

    public Address getAddress() {
        return address;
    }

    public void setLocation(Address a, String n) {
        address = a;
        notes = n;
    }
}
