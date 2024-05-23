package toko;

import java.util.ArrayList;

public class Toko {
    public static MainFrame frame;
    public static ArrayList<Inventory> inventories = new ArrayList();
    public static int currentEditIndex;

    public static void main(String[] args) {
        frame = new MainFrame();
        currentEditIndex = -1; 
        
        frame.setVisible(true);
    }
}
