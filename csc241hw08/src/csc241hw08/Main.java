/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw08;

import java.util.Scanner;

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
        Scanner kb = new Scanner(System.in);
        String[] tokens;
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("Welcome to Binary Tree Sorter");
        System.out.println("Enter a command (i, c, in, pre, post, or q):");
        String command = kb.nextLine();

        while (!command.equals("q")) {
            if(command.equals("in")){
                bst.printInOrder();
            }else if(command.equals("pre")){
                bst.printPreOrder();
            }else if(command.equals("post")){
                bst.printPostOrder();
            }else if(command.startsWith("i ")){
                tokens = command.split("i ");
                if(tokens.length >= 2){
                    bst.insert(tokens[1]);
                }
            }else if(command.startsWith("c ")){
                tokens = command.split("c ");
                   if(tokens.length >= 2){
                       if(!bst.contains(tokens[1])){
                           System.out.println(tokens[1] + " is not in the tree.");
                       }else{
                           System.out.println(tokens[1] + " is contained in the tree.");
                       }
                   }
            }else if(!command.equals("q") &&!command.equals("in") && !command.equals("pre")&&
                    !command.equals("post") && !command.startsWith("i ") && !command.startsWith("c ")){
                System.out.println( "Invalid command -- " + command);
            }
         System.out.println("Enter a command (i, c, in, pre, post, or q):");
         command = kb.nextLine();
        }
        System.out.println("Closing Binary Tree Sorter");
    }

}
