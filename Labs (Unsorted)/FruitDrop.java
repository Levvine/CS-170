// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.util.ArrayList;
import java.util.Random;

import acm.breadboards.NoButtonsBreadboard;
import acm.graphics.GObject;

public class FruitDrop extends NoButtonsBreadboard  {

    private Random random;
    private Fruit fruit;
    private int timerTick;
    private int fruitDelay;
    
    public void run() {
        this.getTextArea().setText("It's raining fruit!");
        
        fruitDelay = 7;        
        timerTick = 0;
        this.getTimer().setDelay(50);
        this.getTimer().start();
    }
    
    public void onTimerTick() {
        if (timerTick % fruitDelay == 0) {
            random = new Random();
            switch (random.nextInt(3)) {
            case 0 : fruit = new Orange(random.nextInt(this.getWidth() - 50)); break;
            case 1 : fruit = new Cherries(random.nextInt(this.getWidth() - 50)); break;
            case 2 : fruit = new Apple(random.nextInt(this.getWidth() - 50)); break;
            } 
        
            fruit.setYAcceleration(1);
            this.add(fruit);
        }
        for (int i = 0; i < this.getElementCount(); i++) {
            GObject element = this.getElement(i);
            if (element instanceof Fruit) {
                ((Fruit) this.getElement(i)).update();
                if (this.getElement(i).getY() > this.getHeight())
                    this.remove(this.getElement(i));
            }
        }
        timerTick++;
        if (timerTick == fruitDelay)
            timerTick = 0;
    }
    
}
