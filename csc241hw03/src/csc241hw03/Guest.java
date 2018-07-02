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
public abstract class Guest {
    private String lastName,firstName;
    
    public Guest(String l, String f){
        lastName = l;
        firstName = f;
    }
    
    public String getFullName(){
        return lastName + ", " + firstName;
    }
}
