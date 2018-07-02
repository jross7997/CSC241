/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw05;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Justin
 */
public class XMLHandler extends DefaultHandler {

    private ArrayList<Holiday> holiList = new ArrayList<Holiday>();
    private Holiday holi;

    public ArrayList<Holiday> getHoliList() {
        return holiList;
    }
    String day = "";
    String name = "";
    String month = "";
    String fed = "";
    String oz = "";


 
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("holidays")) {
            holiList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("holiday")) {    
            day = attributes.getValue("day");
            name = attributes.getValue("name");
            
        } else if (qName.equalsIgnoreCase("month")) {
            month = attributes.getValue("name");
            
        } else if (qName.equalsIgnoreCase("federal")) {
            fed = attributes.getValue("value");
            
        } else if (qName.equalsIgnoreCase("oswego")) {
            oz = attributes.getValue("value");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("holiday")) {
            if(holiList == null){
             holiList = new ArrayList<>();
            }
            holi = new Holiday(month, Integer.parseInt(day), name);
            if (fed.equals("yes")) {
                holi.setFederal(true);
                fed = "";
            } else {
                holi.setFederal(false);
                fed = "";
            }
            if (oz.equals("yes")) {
                holi.setOswego(true);
                oz = "";
            } else {
                holi.setOswego(false);
                oz ="";
            }
            holiList.add(holi);
        }
    }

}
