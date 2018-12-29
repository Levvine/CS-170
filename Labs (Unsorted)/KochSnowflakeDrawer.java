// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.util.Scanner;

import acm.breadboards.OneButtonBreadboard;
import acm.toys.Turtle;

@SuppressWarnings("serial")
public class KochSnowflakeDrawer extends OneButtonBreadboard {
    
     
    public void run() {

        this.getTextArea().setText("This program will use a turtle to draw the nth stage "
                                 + "in the construction of a Koch snowflake. Enter the value"
                                 + " of n and click the 'Go' button");
        
    }
    
    public static String commandWriter(String base) {
        
        Scanner scanner = new Scanner(base);
        String currentCommand = scanner.next();
        String newCommand = (currentCommand.equals("F") ? "F - F + F - F" : currentCommand);
        boolean lastCommand = !scanner.hasNextLine();
        String remainder = (lastCommand ? "" : scanner.nextLine());
        scanner.close();
        return (lastCommand ? newCommand : newCommand + " " + commandWriter(remainder));
        
    }
       
    public static void commandReader(int stage, String command, Turtle turtle) {
        
        // Maximum stage is 5
        Scanner scanner = new Scanner(command);
        double distance = 300 / (!(stage > 0) ? 1 : (4 * Math.pow(3, stage - 1)));
        
        while (scanner.hasNext()) {
            String currentCommand = scanner.next();
            switch (currentCommand) {
            case "F": turtle.forward(distance);break;
            case "+": turtle.right(120);break;
            case "-": turtle.left(60);
            }            
        }
        scanner.close();
                        
    }
        
    public void onButtonClick() {
        
        String command = "F + F + F +";
             
        Scanner scanner = new Scanner(this.getTextField().getText());
        int stage = (!scanner.hasNextInt() ? 0 : scanner.nextInt());
        scanner.close();
        for (int i = stage; i > 0; i--)
            command = commandWriter(command);
       
        Turtle turtle = new Turtle();
        turtle.setLocation(this.getWidth() / 2, 50);
        turtle.setDirection(Math.toRadians(300));
        this.add(turtle);
        
        commandReader(stage, command, turtle);
        
    }

}
