// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.awt.Color;

import acm.graphics.GOval;

public class Orange extends Fruit {

    GOval body;
    
    public Orange(double x) {
        body = new GOval(50,50);
        body.setFilled(true);
        body.setFillColor(Color.ORANGE);
        this.add(body);
        this.setLocation(x, 0);        
    }
    
}
