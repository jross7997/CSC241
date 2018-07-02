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
public class Customer {

    private String lastName, firstName;
    private Address address;
    private ArrayList<Account> accountList = new ArrayList<Account>();

    public Customer(String l, String f, Address a) {
        lastName = l;
        firstName = f;
        address = a;

    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getMailingAddress() {
        return address;
    }

    public Account[] getAccounts() {
        Account[] a = new Account[accountList.size()];
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i) != null) {
                a[i] = accountList.get(i);
            }

        }
        return a;
    }

    public boolean addAccount(Account a) {
        if (a != null) {
            accountList.add(a);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeAccount(Account a) {
        if (a != null) {
            accountList.remove(a);
            return true;
        } else {
            return false;
        }
    }
}
