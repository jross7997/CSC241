/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw05;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
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
    public static void main(String[] args){
        // TODO code application logic here
        try {
        System.out.println("Enter the input file name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        File f = new File(name);	
        
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
             saxParser.parse(f,handler);
            ArrayList<Holiday> holidayList = handler.getHoliList();
            
            for (int i = 0; i < holidayList.size(); i++){
                System.out.println(holidayList.get(i));
            }
            
        } catch (SAXException | ParserConfigurationException |IOException e ) {
            e.printStackTrace();
        }
    }

}
