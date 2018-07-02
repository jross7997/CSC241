/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw06;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Justin
 */
public class XMLHandler extends DefaultHandler {

    private ArrayList<Customer> custList = null;
    private Customer cust = null;
    private String lastName = "", firstName = "";
    private String accountType = "", accountNumber = "";
    private String addressType = "", addressUnit = null, street = "", zipCode = "";
    private int addressNumber;
    private String meterId = "", meterBrand = "", meterType = "", location = "";
    private String meterReading = "", flag = "";
    private LocalDateTime date = null;
    private ArrayList<Account> accountList = new ArrayList<>();
    private ArrayList<Address> addressList = new ArrayList<>();
    private ArrayList<Meter> meterList = null;
    private ArrayList<MeterReading> readingList = new ArrayList<>();

    public ArrayList<Customer> getCustList() {
        return custList;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        if (qName.equalsIgnoreCase("customer")) {
            custList = new ArrayList<>();
            lastName = attributes.getValue("lastName");
            firstName = attributes.getValue("firstName");

        } else if (qName.equalsIgnoreCase("account")) {
            accountType = attributes.getValue("type");
            accountNumber = attributes.getValue("accountNumber");

        } else if (qName.equalsIgnoreCase("address")) {

            addressType = attributes.getValue("type");
            addressUnit = attributes.getValue("unit");
            street = attributes.getValue("street");
            addressNumber = Integer.parseInt(attributes.getValue("number"));
            zipCode = attributes.getValue("zipCode");

        } else if (qName.equalsIgnoreCase("meter")) {
            meterId = attributes.getValue("id");
            meterBrand = attributes.getValue("brand");
            meterType = attributes.getValue("type");
            location = attributes.getValue("location");

        } else if (qName.equalsIgnoreCase("meterReading")) {
            meterReading = attributes.getValue("reading");
            date = LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(attributes.getValue("date"))), ZoneId.systemDefault());;
            flag = attributes.getValue("flag");

        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("meterReading")) {

            if (readingList == null) {
                readingList = new ArrayList<>();
            }
            MeterReading mr = new MeterReading(Double.parseDouble(meterReading), date, flag);
            readingList.add(mr);

        } else if (qName.equalsIgnoreCase("meter")) {
            Meter m;
            if (meterList == null) {
                meterList = new ArrayList<>();
            }
            if (meterType.equals("push")) {
                m = new PushMeter(meterId, meterBrand, meterType);
                
            } else {
                m = new PollMeter(meterId, meterBrand, meterType);
                
            }
                m.setLocation(location);
                
            for(int i = 0;i < readingList.size();i++){
                readingList.get(i).setMeter(m);
                m.addReading(readingList.get(i));
            }
            readingList = null;
            
            if(m != null){
                meterList.add(m);
            }

        } else if (qName.equalsIgnoreCase("address")) {
            Address ad = null;
            if (addressList == null) {
                addressList = new ArrayList<>();
            }
            if (meterList == null) {
                meterList = new ArrayList<>();
            }
            if (addressType.equals("mailing")) {
                ad = new House(street, addressNumber, zipCode, addressType);
            }
            else if (addressType.equals("commercial")) {
                ad = new Commercial(street, addressNumber, zipCode, addressType);
            } else if (addressType.equals("apartment")) {
                ad = new Apartment(street, addressNumber, zipCode, addressType, addressUnit);
            
            } else {
            }
            if (ad != null) {
                
                  for (int i = 0; i < meterList.size(); i++) {

                meterList.get(i).setLocation(ad);
               ad.addMeter(meterList.get(i));
                    

            }
            addressList.add(ad);        
            meterList = null;
            }

        } else if (qName.equalsIgnoreCase("account")) {
            Account ac;
            if (accountList == null) {
                accountList = new ArrayList<>();
            }
            if (accountType.equals("residential")) {
                ac = new ResidentialAccount(accountNumber, null);

            } else {
                ac = new CommercialAccount(accountNumber, null);
            }
            accountNumber = "";
            for (int i = 0; i < addressList.size(); i++) {
                if (addressList.get(i) != null) {
                    addressList.get(i).setAccount(ac);
                    ac.addAddress(addressList.get(i));
                }

            }

            addressList = null;
           accountList.add(ac);

        } else if (qName.equalsIgnoreCase("customer")) {
            
            if(custList == null){
                custList = new ArrayList<>();
            }
            Address ad = null;
            
            for(int i = 0; i < accountList.size();i++){
                Account ac = accountList.get(i);
                
                Address[] addressArray = ac.getAddresses();
                
                for (int j = 0; j < addressArray.length; j++) {
                    if(addressArray[j].getType().equals("mailing")){
                        ad = addressArray[j];
                        
                    }
                    
                }
            }
            
            Customer cust1 = new Customer(lastName, firstName, ad);

            for (int i = 0; i < accountList.size(); i++) {
              cust1.addAccount(accountList.get(i));
            }

            if(custList.add(cust1)){
             //   System.out.println("new customer added");
            }
                
            
        }
    }

}
