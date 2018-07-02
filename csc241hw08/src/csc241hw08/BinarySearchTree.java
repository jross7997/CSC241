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
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(String v) {
        if (root == null) {
            root = new Node(v);
        } else {
            root.insert(v);
        }
    }

    public boolean contains(String v) {
        if (root == null) {
            return false;
        } else {
            return root.contains(v);
        }
    }

    public void printInOrder() {
        if (root == null) {
            System.out.println("The tree has no nodes.");
        } else {
            System.out.println("In-order:");
            root.printInOrder();
            System.out.println();
        }

    }

    public void printPreOrder() {
        if (root == null) {
            System.out.println("The tree has no nodes.");
        } else {
            System.out.println("Pre-order:");
            root.printPreOrder();
            System.out.println();
        }
    }

    public void printPostOrder() {
        if (root == null) {
            System.out.println("The tree has no nodes.");
        } else {
            System.out.println("Post-order:");
            root.printPostOrder();
            System.out.println();
        }
    }

}
