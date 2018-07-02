/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc241hw08;

/**
 *
 * @author Justin
 */
public class Node {

   private Node right, left;
    private String value;

    public Node(String v) {
        value = v;
    }

    public Node insert(String v) {

        if (value.compareTo(v) >= 0) {
            if (left == null) {
                left = new Node(v);
            } else {
                left = left.insert(v);
            }
            return this;
        } else {
            if (right == null) {
                right = new Node(v);
            } else {
               right = right.insert(v);
            }
            return this;
        }
    }

    public boolean contains(String v) {
        if (value.equals(v)) {
            return true;
        } else if (value.compareToIgnoreCase(v) >= 0) {
            if (left == null) {
                return false;
            } else {
                return left.contains(v);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(v);
            }
        }
    }

    public void printInOrder() {
        
        if(left != null){
            left.printInOrder();
        }
        
        System.out.print("[" + value + "]");
        
        if(right != null){
            right.printInOrder();
        }
        
    }
    
  

    public void printPreOrder() {
        
      System.out.print("[" + value + "]");
     
       if(left != null){
            left.printPreOrder();
        }
       
        if(right != null){
            right.printPreOrder();
        }
      
    }

    public void printPostOrder() {
       if(left != null){
            left.printPostOrder();
        }
       
        if(right != null){
            right.printPostOrder();
        }
        System.out.print("[" + value + "]");
    }
}
