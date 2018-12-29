package finalProject;

import acm.graphics.GImage;

public class Item implements ItemList {

    private int ItemID;
    private GImage icon;
    private int type;
    
    public static final int WEAPON = 1;
    
    public Item(int a) {
        ItemID = a;
        if(this instanceof Weapon) {
            type = WEAPON;
        }
    }
    
    public void setItemID(int a) {
        ItemID = a;
    }
    
    public int getItemID() {
        return ItemID;
    }
    
}
