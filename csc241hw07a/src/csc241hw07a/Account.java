/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07a;

import java.util.ArrayList;

/**
 *
 * @author Justin
 */
public abstract class Account {

    private String accountNum;
    private double balance = 0;
    private ArrayList<Address> addressList = new ArrayList<Address>();
    private Customer c1;

    public Account(String a, Customer c) {
        accountNum = a;
        c1 = c;
    }

    public String getAccountNumber() {
        return accountNum;
    }

    public Customer getCustomer() {
        return c1;
    }

    public double getCurrentBalance() {
        return balance;
    }

    public Address[] getAddresses() {
        Address[] a = new Address[addressList.size()];
        a = addressList.toArray(a);
        return a;
    }

    public boolean addAddress(Address a) {
        if (a != null) {
            addressList.add(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAddress(Address a) {
        if (a != null) {
            addressList.remove(a);
            return true;
        } else {
            return false;
        }
    }

    public void setBalance(double b) {
        balance = b;
    }

    public abstract void updateBalance();

    public abstract String getType();

        public void printAddresses(Address[] ad){
        
        for (Address ad1 : ad) {
            System.out.println("  " + ad1.toString()); 
        }

}
}