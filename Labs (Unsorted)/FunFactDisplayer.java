import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class FunFactDisplayer {

    public static void main(String[] args) throws FileNotFoundException {
        
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's your name? ");
        String name = scanner.nextLine();
        
        System.out.print("Pick a year: (1886, 1928, or 1969) ");
        String year = scanner.nextLine();
        
        File yearFile = new File(args[0] + year + ".txt");
        Scanner fileScanner = new Scanner(yearFile);
        
        final JDialog dialog = new JDialog(); //forces joptionpane to appear on top
        dialog.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(dialog, "In " + year + ", " 
                + fileScanner.nextLine(), name + ", did you know...",1);
        dialog.setVisible(false); //closes jdialog so scanner and printwriter can work
        
        System.out.println("Your turn - tell me a fun fact about this year.");
        String funFact = scanner.nextLine();
        scanner.close();
        
        File funFile = new File(args[0] + "2017.txt");
        PrintWriter printWriter = new PrintWriter(funFile);
        printWriter.print(funFact);
        printWriter.close();
        System.out.println("I recorded your fun fact in a file named \"2017.txt\"");
        
    }
    
}
