package finalProject;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Unit extends GCompound implements Class, UnitInventory, UnitList {

    private static int count; // starts from 1
    private int index; // starts from 0
    
    private boolean selected;
    
    private int classID;
    
    private int baseHitpoints;
    private int baseStrength;
    private int baseDefense;
       
    private int classHitpoints;
    private int classStrength;
    private int classDefense;
    private int classMovement;
    
    private int totalHitpoints;
    private int totalAttack;
    private int totalDefense;
    
    private int damageTaken;
    
    private int weaponRange;
    private int actionRange;
    private int healRange;
    
    private int[][] actionTiles; // unit available actions relative to map
       
    private boolean alive;
    
    private int equippedWeapon;
    
    public Unit (int a, int b, int c) {
        index = count;
        count++;
        //MapOverlay.addRangeIndicator(this);
        unitList.add(index, this);
        Map.getData()[0][0].setOccupant(this);
        
        baseHitpoints = a;
        baseStrength = b;
        baseDefense = c;
        
        equippedWeapon = -1;
        weaponRange = 0;
        
        alive = true;     
        
    }
    
    public static int getEnemies() {
        int enemies = 0;
        for (int i = 0; i < unitList.size(); i++) {
            if (unitList.get(i) instanceof EnemyUnit) {
                enemies++;
            }
        }
        return enemies;
    }
    
    public void attack(Unit z) { //z = fruit
        
        //System.out.println(((PlayerUnit) this).getName() + " HP: " + totalHitpoints);
        //System.out.println(((PlayerUnit) this).getName() + " Attack: " + totalAttack);
        
        z.setDamageTaken(z.getDamageTaken() + this.totalAttack); 
        update(); z.update();
        //System.out.println("_---------------_");
        z.counterAttack(this);
    }
    
    public void counterAttack(Unit z) { //z = marth
        //System.out.println(((EnemyUnit) this).getName() + " HP: " + totalHitpoints);
        //System.out.println(((PlayerUnit) z).getName() + " HP: " + z.getTotalHitpoints());
        
        z.setDamageTaken(z.getDamageTaken() + this.totalAttack);
        update(); z.update();
    }
    
    public void snapToGrid() {
        setCenterLocation(getTileColumn() * 53 + Map.getTileSize()/2, getTileRow() * 53 + Map.getTileSize()/2);
    }
    
    public void setSelected(boolean a) {
        if (a)
            Map.genActionTiles(this);
        selected = a;
    }
    
    public void addItem(Item item) {
        if (item instanceof Weapon) {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i].getItemID() == Item.NULL) {
                    inventory[i] = item;
                    if (equippedWeapon == -1)
                        equipWeapon(i);
                    break;
                }
            }
        }
    }
    
    public void equipWeapon(int a) {
        if (inventory[a] instanceof Weapon) {
            switch(a) {
            case 0 : equippedWeapon = 0; break;
            case 1 : equippedWeapon = 1;break;
            case 2 : equippedWeapon = 2; break;
            case 3 : equippedWeapon = 3; break;
            case 4 : equippedWeapon = 4; break;
            }
        update();
        }
    }
       
    public void move(int x, int y) {
    }
    
    public void death() {
        if (this instanceof PlayerUnit) {
            this.setVisible(false);
            Map.getData()[getTileRow()][getTileColumn()].setOccupant(null);
            Main.getTextArea().setText("Game Over");
            unitList.remove(this);
        }
        else if (this instanceof EnemyUnit) {
            this.setVisible(false);
            Map.getData()[getTileRow()][getTileColumn()].setOccupant(null);
            Main.getTextArea().setText(((EnemyUnit) this).getName() + " was slain!");
            unitList.remove(this);
        }
    }
    
    public boolean getAlive() {
        return alive;
    }
    
    public boolean isCounterAttacking() {
        return true; //
    }
    
    public void setClassID(int id) {
        switch(id) {
        case KNIGHT : classID = KNIGHT; 
        classHitpoints = 100; classStrength = 10; classDefense = 20; classMovement = 1; break;
        case MERCENARY : classID = MERCENARY; 
        classHitpoints = 80; classStrength = 15; classDefense = 15; classMovement = 2; break;
        case FIGHTER : classID = FIGHTER;
        classHitpoints = 90; classStrength = 20; classDefense = 10; classMovement = 2; break;
        }
        
        update();
    }
    
    public void setBaseHitpoints(int a) {
        baseHitpoints = a;
    }
    
    public void setBaseStrength(int b) {
        baseStrength = b;
    }
    
    public void setBaseDefense(int c) {
        baseDefense = c;
    }
    
    public void setClassHitpoints(int a) {
        classHitpoints = a;
    }
    
    public void setClassStrength(int b) {
        classStrength = b;
    }
    
    public void setClassDefense(int c) {
        classDefense = c;
    }
    
    public void setClassMovement(int d) {
        classMovement = d;
    }
    
    public void setDamageTaken(int z) {
        damageTaken = z;
    }
    
    public void setWeaponRange(int e) {
        weaponRange = e;
    }
    
    public void setActionRange(int f) {
        actionRange = f;
    }
    
    public void setActionTiles(int[][] g) {
        actionTiles = g;
    }
    
    private void setCenterLocation(double x, double y) {
        setLocation(x - getWidth()/2, y - getHeight()/2);
    }
    
    public void setTileLocation(int row, int column) {
        Map.getData()[getTileRow()][getTileColumn()].setOccupant(null);
        setCenterLocation(column * Map.getTileSize(), row * Map.getTileSize());
        Map.getData()[row][column].setOccupant(this);
        snapToGrid();
    }    
    
    public static int getCount() {
        return count;
    }
    
    public int getIndex() {
        return index;
    }
    
    public boolean getSelected() {
        return selected;
    }
    
    public int getClassID() {
        return classID;
    }
        
    public int getBaseHitpoints() {
        return baseHitpoints;
    }
    
    public int getBaseStrength() {
        return baseStrength;
    }
    
    public int getBaseDefense() {
        return baseDefense;
    }
    
    public int getClassHitpoints() {
        return classHitpoints;
    }
    
    public int getClassStrength() {
        return classStrength;
    }
    
    public int getClassDefense() {
        return classDefense;
    }
    
    public int getClassMovement() {
        return classMovement;
    }
    
    public int getTotalHitpoints() {
        return totalHitpoints;
    }
    
    public int getTotalAttack() {
        return totalAttack;
    }
    
    public int getDamageTaken() {
        return damageTaken;
    }
    
    public int getWeaponRange() {
        return weaponRange;
    }
    
    public int getHealRange() {
        return healRange;
    }
    
    public int getActionRange() {
        return actionRange;
    }
    
    public int[][] getActionTiles() {
        return actionTiles;
    }
    
    public double getCenterX() {
        return super.getX() + super.getWidth()/2.0;
    }
    
    public double getCenterY() {
        return super.getY() + super.getHeight()/2.0;
    }
    
    public int getTileRow() {
        return (int) (getCenterY() / Map.getTileSize());
    }
    
    public int getTileColumn() {
        return (int) (getCenterX() / Map.getTileSize());
    }
    
    public void update() {
        //update range
        totalHitpoints = baseHitpoints + classHitpoints - damageTaken;
        if (totalHitpoints < 0) {
            totalHitpoints = 0;
            this.death();
        }
        
        
        totalAttack = baseStrength + classStrength; //15 + 10
        totalAttack += ((Weapon) inventory[equippedWeapon]).getMight(); //2
        
        if (equippedWeapon >= 0 && inventory[equippedWeapon] instanceof Weapon) {
            switch (((Weapon) inventory[equippedWeapon]).getType()) {
            case Weapon.LANCE : weaponRange = 1; break;
            case Weapon.SWORD : weaponRange = 1; break;
            case Weapon.AXE : weaponRange = 1; break;
            }
        }
                
        actionRange = classMovement + (weaponRange > healRange ? weaponRange : healRange);
         // updates ActionTiles and mods map overlay
    }
    
}
    