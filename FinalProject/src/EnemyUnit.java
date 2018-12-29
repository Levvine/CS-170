package finalProject;

import acm.graphics.GImage;

public class EnemyUnit extends Unit {

    private GImage graphics;
    private String name;
    
    public EnemyUnit(String name, int classID) {
        super(100, 10, 10);
        this.name = name;
        switch (classID) {
        case Class.KNIGHT : super.addItem(new Weapon(Weapon.BRONZE_LANCE)); graphics = new GImage(KNIGHT_IMG); break;
        case Class.MERCENARY : super.addItem(new Weapon(Weapon.BRONZE_SWORD)); graphics = new GImage(MERC_IMG); break;
        case Class.FIGHTER : super.addItem(new Weapon(Weapon.BRONZE_AXE)); graphics = new GImage(FIGHT_IMG); break;
        }
        super.setClassID(classID);
        
        
        this.add(graphics);
    }
    
    public String getName() {
        return name;
    }
    
    
    
}

