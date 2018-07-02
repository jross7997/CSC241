/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

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
            System.out.println("Enter the input file name:");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            File f = new File(name);
            Account[] a = null;
            Address[] ad = null;
            
            DecimalFormat formatter = new DecimalFormat("0.00");

            System.out.println("Enter the account number:");
            String account = sc.nextLine();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(f, handler);
            ArrayList<Customer> custList = handler.getCustList();

            boolean bool = false;

            for (int i = 0; i < custList.size(); i++) {
                a = custList.get(i).getAccounts();

                for (int j = 0; j < a.length; j++) {

                    if (a != null) {
                        if (a[j].getAccountNumber().equals(account)) {
                            a[j].updateBalance();
                            double balance = a[j].getCurrentBalance();
                            
                                System.out.println("Balance: $" + formatter.format(balance));
                                bool = true;
                                
                            
                        }
                    }
                }

            }

            if (!bool) {
                System.out.println("Account number " + account + " not found.");
            }

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

}
