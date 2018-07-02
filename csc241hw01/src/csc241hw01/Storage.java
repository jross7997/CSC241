package csc241hw01;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Justin
 */
public class Storage {

    private ArrayList<String> arrayList = new ArrayList<>();

    public boolean addItem(String s) {
        if (s != null) {
            return arrayList.add(s);
        } else {
            return false;
        }
    }

    public String[] getItems() {
        String items[] = new String[arrayList.size()];
        items = arrayList.toArray(items);
        return items;
    }

    public boolean isFull() {
        return false;
    }

    public boolean removeItem(String s) {
        if (s == null) {
            return false;
        } else {
            return arrayList.remove(s);
        }
    }
}
