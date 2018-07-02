/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw02;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Justin
 */

public class MeterReading {
    private float reading;
    private String flag,type;
    private LocalDateTime time;
    private ArrayList<Meter> meterList = new ArrayList<Meter>();
    private Meter m1;
    
    //(expReading, expDateTime, expFlag, expMeter);
    public MeterReading(float r,LocalDateTime t, String f, Meter m){
        reading = r;
        flag = f;
        time = t;
        m1 = m;
    }
    public LocalDateTime getDateTime(){
      return time;
    }
    public float getReading(){
        return reading;
    }
    public String getFlag(){
        return flag;
    }
    public Meter getMeter(){
        return m1;
    }
}