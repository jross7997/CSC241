/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw07a;

/**
 *
 * @author Justin
 */

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class XMLHandler extends DefaultHandler {
   
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private Customer currentCustomer;
    private Account currentAccount;
    private Address currentAddress;
    private Meter currentMeter;

    public ArrayList<Customer> getCustList() {
        return customerList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("customer")) {
            String lastName = attributes.getValue("lastName");
            String firstName = attributes.getValue("firstName");
            currentCustomer = new Customer(lastName, firstName);

        } else if (qName.equalsIgnoreCase("address")) {
            String street = attributes.getValue("street");
            int houseNumber = Integer.parseInt(attributes.getValue("number"));
            String zipCode = attributes.getValue("zipCode");
            String type = attributes.getValue("type");
            String unit = attributes.getValue("unit");

            if (type.equalsIgnoreCase("mailing")) {
                MailingAddress ma = new MailingAddress(street, houseNumber, zipCode, type);
                currentCustomer.setMailingAddress(ma);
            } else if (type.equalsIgnoreCase("house")) {
                currentAddress = new House(street, houseNumber, zipCode, type);
            } else if (type.equalsIgnoreCase("commercial")) {
                currentAddress = new Commercial(street, houseNumber, zipCode, type);
            } else if (unit != null) {
                currentAddress = new Apartment(street, houseNumber, zipCode, type, unit);
            } else {
                System.out.println("Unknown address type:" + type);
            }


            if (currentAddress != null) {
                currentAddress.setAccount(currentAccount);
                currentAccount.addAddress(currentAddress);
            }

        } else if (qName.equalsIgnoreCase("meter")) {
            String type = attributes.getValue("type");
            String brand = attributes.getValue("brand");
            String id = attributes.getValue("id");
            if (type.equalsIgnoreCase("push")) {
                currentMeter = new PushMeter(id, brand, type);
            } else if (type.equalsIgnoreCase("poll")) {
                currentMeter = new PollMeter(id, brand, type);
            } else {
                System.out.println("Unknown meter type: " + type);
            }

            if (currentMeter != null) {
                String location = attributes.getValue("location");
                currentMeter.setLocation(currentAddress, location);
                currentAddress.addMeter(currentMeter);
            }

        } else if (qName.equalsIgnoreCase("meterReading")) {
            double reading = Double.parseDouble(attributes.getValue("reading"));
            ZoneOffset z = ZoneOffset.ofHours(5);
            long epoch = Long.parseLong(attributes.getValue("date"));
            LocalDateTime d = LocalDateTime.ofEpochSecond(epoch,0,z);
            String flag = attributes.getValue("flag");
            MeterReading mr = new MeterReading(reading, d, flag, currentMeter);
            currentMeter.addReading(mr);

        } else if (qName.equalsIgnoreCase("account")) {
            String type = attributes.getValue("type");
            String acctNum = attributes.getValue("accountNumber");
            
            if (type.equalsIgnoreCase("residential")) {
                currentAccount = new ResidentialAccount(acctNum, currentCustomer);
            } else if (type.equalsIgnoreCase("commercial")) {
                currentAccount = new CommercialAccount(acctNum, currentCustomer);
            } else {
                System.out.println("Unknown account type:" + type);
            }
            
            if (currentAccount != null) {
                currentCustomer.addAccount(currentAccount);
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("customer")) {
            customerList.add(currentCustomer);
            currentCustomer = null;
        } else if (qName.equalsIgnoreCase("meter")) {
            currentMeter = null;
        } else if (qName.equalsIgnoreCase("account")) {
            currentAccount = null;
        } else if (qName.equalsIgnoreCase("address")) {
            currentAddress = null;
        }
    }
}
    
    
    

