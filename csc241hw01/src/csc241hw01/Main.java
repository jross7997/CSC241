package csc241hw01;
/**
 * @author Justin
 */
public class Main {

    public static void main(String[] args) {
        boolean added;
        Storage storageObject = new Storage();
        for (int i = 0; i < 500001; i++) {
         storageObject.addItem("booooop" + i);
            
        }
        added = storageObject.addItem("bop");
        if(added == true){
            System.out.println(storageObject.getItems()[0]);
            System.out.println(storageObject.isFull());
            System.out.println(storageObject.getItems()[500001]);
            System.out.println(storageObject.removeItem("booooop2"));
            
        }
    }
    
}
