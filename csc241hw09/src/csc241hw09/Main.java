/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Justin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic 
        try{
        Scanner kb = new Scanner(System.in);
        HashMap map = new HashMap<String,String>();
        
        System.out.println("Enter the file name:");
        String fileName = kb.nextLine();
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] index = line.split(" ", 2);
            map.put(index[0],index[1]);
        }
        
        System.out.println("Enter a key value:");
        String key = kb.nextLine();
        
        if(map.containsKey(key)){
            System.out.println("Value: " + map.get(key));
        }else{
            System.out.println("No value found");
        }
        
        }catch(Exception e){
            System.out.println("File Not Found");
        }
        
    }
    
}
