package finalProject;

public class Weapon extends Item implements WeaponType {

    private int might;
    private int type;
    
    public Weapon(int id) {
        super(id);
        this.setStats();
    }
    
    public void setStats() {
        switch(super.getItemID()) {
        case BRONZE_LANCE : might = 2; type = LANCE; break;
        case BRONZE_SWORD : might = 2; type = SWORD; break;
        case BRONZE_AXE : might = 2; type = AXE; break;
        }
    }
    
    public void setMight(int a) {
        might = a;
    }
    
    public void setType(int a) {
        type = a;
    }
    
    public int getMight() {
        return might;
    }
    
    public int getType() {
        return type;
    }
    
}
