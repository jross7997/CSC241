/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw04;

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

}
