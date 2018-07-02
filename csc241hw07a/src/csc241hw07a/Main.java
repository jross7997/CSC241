/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07a;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Justin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            DecimalFormat formatter = new DecimalFormat("0.00");
            Scanner kb = new Scanner(System.in);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            ArrayList<Customer> custList = new ArrayList<>();
            System.out.println("Welcome to the Energy Management System");
            System.out.println("Enter a command:");
            String command = kb.nextLine();

            while (!command.equals("quit")) {
                if (command.contains("load")) {
                    try {
                        String[] tokens = command.split("load ");
                        if (tokens.length >= 2) {
                            File f = new File(tokens[1]);
                            saxParser.parse(f, handler);
                            ArrayList<Customer> newList = handler.getCustList();
                            for (int i = 0; i < newList.size(); i++) {
                                custList.add(newList.get(i));
                            }

                            System.out.println("Load successful: " + tokens[1]);
                        } else {
                            System.out.println("Invalid input file - ");
                        }

                    } catch (Exception e) {
                        String[] tokens = command.split(" ");
                        System.out.println("Invalid input file - " + tokens[1]);
                    }
                } else if (command.contains("show customer")) {
                    String[] tokens = command.split(" ");
                    boolean found = false;

                    if (tokens.length >= 3) {

                        for (int i = 0; i < custList.size(); i++) {
                            if (custList.get(i).getLastName().equals(tokens[2])) {
                                custList.get(i).printInfo();
                                found = true;

                            }
                        }
                        if (!found) {
                            System.out.println("No records found");
                        }
                    } else {
                        System.out.println("Invalid command " + command);
                    }
                } else if (command.contains("show account")) {

                    String[] tokens = command.split(" ");

                    if (tokens.length >= 3) {
                        boolean found = false;
                        Address[] ad = null;

                        for (int i = 0; i < custList.size(); i++) {
                            Account[] a = custList.get(i).getAccounts();

                            for (int j = 0; j < a.length; j++) {

                                if (a != null) {
                                    if (a[j].getAccountNumber().equals(tokens[2])) {
                                        a[j].updateBalance();
                                        ad = a[j].getAddresses();
                                        Account ac = a[j];

                                        System.out.println("Account number: " + tokens[2] + "\nBalance: $" + formatter.format(a[j].getCurrentBalance()) + "\nAddresses:");
                                        ac.printAddresses(ad);

                                        found = true;

                                    }
                                }
                            }

                        }

                        if (!found) {
                            System.out.println("No records found");
                        }
                    } else {
                        System.out.println("No records found");
                    }

                } else if (command.contains("show address")) {
                    String[] tokens = command.split("show address ");
                    if (tokens.length >= 2) {
                        boolean found = false;
                        Address[] ad;
                        Meter[] m;

                        for (int i = 0; i < custList.size(); i++) {
                            Account[] a = custList.get(i).getAccounts();
                            for (int j = 0; j < a.length; j++) {
                                ad = a[j].getAddresses();

                                for (int k = 0; k < ad.length; k++) {

                                    if (ad[i].toString().equals(tokens[1])) {
                                        m = ad[i].getMeters();
                                        ad[i].printInfo(m);
                                        found = true;
                                    }

                                }
                            }

                        }
                        if (!found) {
                            System.out.println("No records found");
                        }
                    } else {
                        System.out.println("No records found");
                    }

                } else if (command.contains("show meter")) {
                    String[] tokens = command.split("show meter ");
                    Account[] ac;
                    Address[] ad;
                    Meter[] m;
                    MeterReading[] mr;
                    boolean found = false;

                    if (tokens.length >= 2) {
                        for (int i = 0; i < custList.size(); i++) {
                            ac = custList.get(i).getAccounts();
                            for (int j = 0; j < ac.length; j++) {
                                 ad = ac[j].getAddresses();
                                for (int k = 0; k < ad.length; k++) {
                                     m = ad[k].getMeters();
                                    for (int l = 0; l < m.length; l++) {
                                     if (m[l].getID().equals(tokens[1])) {
                                        mr = m[l].getReadings();
                                        m[l].printReadings(mr);
                                        found = true;
                                    }
                                  }
                               }
                            }
                        }

                    }
                    if(!found){
                        System.out.println("No records found");
                    }

                } else if (command.contains("clear")) {
                    custList = new ArrayList<>();
                } else {
                    System.out.println("Invalid command: " + command);
                }
                System.out.println("Enter a command:");
                command = kb.nextLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Program ending");
    }

}
