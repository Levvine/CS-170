package finalProject;

import java.util.ArrayList;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class MapOverlay extends GCompound {
    
    static ArrayList<RangeIndicator> indicatorList;
    
    public MapOverlay() {
        indicatorList = new ArrayList<RangeIndicator>(Unit.getCount());
        
    }
    
    public static void addRangeIndicator(Unit a) {
        indicatorList.add(new RangeIndicator(a));
    }
    
    public void modRangeIndicator(Unit a) {
        //System.out.println("index: " + a.getIndex() + " name: " + ((GenericUnit) a).getName());
        //System.out.println("ActionTiles length: " + a.getActionTiles().length);
        //indicatorList.get(a.getIndex()).update(a.getActionTiles());
        System.out.println("loop");
        if (a.getSelected()) {
            
            this.add(indicatorList.get(a.getIndex()).getIndicator());
            this.add(new GImage("apple.png"));
        }
    }
    
}
