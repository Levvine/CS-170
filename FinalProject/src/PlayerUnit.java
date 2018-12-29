package finalProject;

import acm.graphics.GImage;

public class PlayerUnit extends Unit {

    private GImage graphics;
    private String name;
    
    public PlayerUnit(String name, int classID) {
        super(500, 20, 20);
        this.name = name;
        switch (classID) {
        case Class.KNIGHT : super.addItem(new Weapon(Weapon.BRONZE_LANCE)); graphics = new GImage(KNIGHT_IMG); break;
        case Class.MERCENARY : super.addItem(new Weapon(Weapon.BRONZE_SWORD)); graphics = new GImage("bin/Marth.png"); break;
        case Class.FIGHTER : super.addItem(new Weapon(Weapon.BRONZE_AXE)); graphics = new GImage(FIGHT_IMG); break;
        }
        super.setClassID(classID);
        
        
        this.add(graphics);
    }
    
    public String getName() {
        return name;
    }
    
    public void setGraphics(GImage image) {
        graphics = image;
        System.out.println("graphics set");
    }
    
    
    
}
