package finalProject;

public class Tile implements UnitList {

    private boolean passable;
    private Unit[] occupant;
    
    public Tile(boolean passable) {
        this.passable = passable;
        this.occupant = new Unit[2];
    }

    public boolean getPassable() {
        return passable;
    }
    
    public Unit getOccupant() {
        return occupant[0];
    }
    
    public boolean hasOccupant() {
        return !(occupant[0] == null);
    }
    
    public void setPassable(boolean passable) {
        this.passable = passable;
    }
    
    public void setOccupant(Unit a) {
        occupant[0] = a;
    }
    
    public void update() {
        
    }
    
}
