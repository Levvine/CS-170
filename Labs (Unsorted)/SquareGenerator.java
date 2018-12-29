import java.awt.Color;
import java.util.Random;
import java.util.Scanner;

import acm.breadboards.OneButtonBreadboard;
import acm.graphics.GRect;

public class SquareGenerator extends OneButtonBreadboard {

    GRect rect;
    Random random;
    int timerTick;
    int height;
    int width;
    Color color;
    int rectSize; 
    boolean customSize = false; // are false by default
    boolean customColor = false;
    
    int sizeLimitUpper = 100; // so the squares won't be stupidly massive
    int sizeLimitLower = 20;
    
    public void run() {
                
        height =  this.getHeight();
        width = this.getWidth();
        System.out.println(height +" " +  width);
                
        this.getTextArea().setText("Click \"Draw\" to draw a square. It will be"
                                 + "of random size, color, and location unless"
                                 + " you type \"color = \" followed by \"red\","
                                 + " \"green\", or \"blue\". You may instead"
                                 + "specify the size (i.e., side length) by "
                                 + "typing \"size = \" followed by some decimal "
                                 + "value.");
        this.getButton().setText("Draw!");
        this.getTimer().setDelay(50);
        
    }
    
    public void onButtonClick() {
        
        Scanner scanner = new Scanner(this.getTextField().getText());
        
        
        if(scanner.hasNext()) {
            
            String userInputChoice = scanner.next().toLowerCase();
            
            if(userInputChoice.equals("color") && scanner.hasNext() && 
               scanner.next().equals("=")) {
            
                customColor = true;
                
                if(scanner.hasNext()) {
                    
                    String userInputColor = scanner.next().toLowerCase();
                    
                    if(userInputColor.equals("green"))
                        color = new Color(0,255,0);
                    else if(userInputColor.equals("blue"))
                        color = new Color(0,0,255);
                    else if(userInputColor.equals("red"))
                        color = new Color(255,0,0);
                    else {
                        this.getTextField().setText("Invalid color");
                        customColor = false;
                    }
                    
                }
                else { 
                    
                    this.getTextField().setText("Invalid input");
                    customColor = false;
                    
                }
                
                
            }
            
            else if(userInputChoice.equals("size") && scanner.hasNext() &&
                    scanner.next().equals("=")) {
                
                customSize = true;
                
                if(scanner.hasNextInt()) {
                    
                    rectSize = scanner.nextInt();
                                        
                }
                else { 
                    
                    this.getTextField().setText("Invalid size");
                    customSize = false;
                    
                }
                
                
            }
            else {
                
                this.getTextField().setText("Invalid input");
                
            }
            
        }
        
        this.getTimer().start();  
        
        
        
    }
    
    public void onTimerTick() {
        
        int rectX;
        int rectY;
        int rectPossibleHeight = 1;
        int rectPossibleWidth = 1;    

        
        random = new Random();
        
        if (!customSize) {
    
                rectSize = random.nextInt(sizeLimitUpper - sizeLimitLower)
                         + sizeLimitLower;
                              
        }
        
        rectX = random.nextInt(width - rectSize);
        rectY = random.nextInt(height - rectSize);
        
        rect = new GRect(rectX, rectY, rectSize, rectSize);
        
        if (!customColor){
            
            color = new Color(random.nextInt(255), random.nextInt(255)
                            , random.nextInt(255));
            
        }
        rect.setFillColor(color);
        rect.setFilled(true);
        
        this.add(rect);
        
        
        
        timerTick++;
        
        if (timerTick == 50) { 
            
            this.getTimer().stop();
            timerTick = 0;
            
        }
        
    }
    
}
