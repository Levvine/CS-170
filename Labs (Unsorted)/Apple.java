// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import acm.graphics.GImage;

public class Apple extends Fruit {
    
    private GImage image;
    
    public Apple(double x) {
        image = new GImage("apple.png");
        this.add(image);
        this.setLocation(x, 0);
    }

}
