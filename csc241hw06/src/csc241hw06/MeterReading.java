/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */

public class MeterReading {
    private double reading;
    private String flag,type;
    private LocalDateTime time;
    private ArrayList<Meter> meterList = new ArrayList<Meter>();
    private Meter m1;
    
    public MeterReading(double r,LocalDateTime t, String f, Meter m){
        reading = r;
        flag = f;
        time = t;
        m1 = m;
    }
    
    public MeterReading(double r, LocalDateTime t, String f){
             reading = r;
        flag = f;
        time = t;
   
    }
    public LocalDateTime getDateTime(){
      return time;
    }
    public double getReading(){
        return reading;
    }
    public String getFlag(){
        return flag;
    }
    public Meter getMeter(){
        return m1;
    }
    public void setMeter(Meter m){
        m1 = m;
    }
}
