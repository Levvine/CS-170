// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.awt.Color;

import acm.graphics.GArc;
import acm.graphics.GOval;

public class Cherries extends Fruit {

    GOval body1;
    GOval body2;
    GArc stem1;
    GArc stem2;
    
    public Cherries(double x) {
        body1 = new GOval(0,20,20,20);
        body2 = new GOval(20,20,20,20);
        stem1 = new GArc(10,0,30,50,90,90);
        stem2 = new GArc(20,0,20,20,90,180);
        
        body1.setFilled(true);
        body2.setFilled(true);
        body1.setFillColor(Color.RED);
        body2.setFillColor(Color.RED);
        stem1.setColor(Color.GREEN);
        stem2.setColor(Color.GREEN);
        
        this.add(stem1);
        this.add(stem2);
        this.add(body1);
        this.add(body2);
        
        this.setLocation(x,-10);
    }
    
}
