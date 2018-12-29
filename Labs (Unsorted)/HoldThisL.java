import java.util.Scanner;

public class HoldThisL {
    
    public static String lCopier(String string) {
        
        Scanner scanner = new Scanner(string);
        String currentCommand = scanner.next();
        boolean lastCommand = !scanner.hasNextLine();
        String remainder = (lastCommand ? "" : scanner.nextLine());
        scanner.close();
        return (lastCommand ? currentCommand : currentCommand + " " + lCopier(remainder));
                
    }
    
    public static String lReplacer(String string) {
        
        Scanner scanner = new Scanner(string);
        String currentCommand = scanner.next();
        String newCommand = (currentCommand.equals("W") ? "L" : currentCommand);
        boolean lastCommand = !scanner.hasNextLine();
        String remainder = (lastCommand ? "" : scanner.nextLine());
        scanner.close();
        return (lastCommand ? newCommand : newCommand + " " + lReplacer(remainder));
        
    }
    
    public static String lMultiplier(String string) {
        
        Scanner scanner = new Scanner(string);
        String currentCommand = scanner.next();
        String newCommand = (currentCommand.equals("L") ? "L L" : currentCommand);
        boolean lastCommand = !scanner.hasNextLine();
        String remainder = (lastCommand ? "" : scanner.nextLine());
        scanner.close();
        return (lastCommand ? newCommand : newCommand + " " + lMultiplier(remainder));
        
    }
        
    
    public static void main(String[] args) {
        
        String string = "W + - W + - W";
        string = lCopier(string);  
        System.out.println("lCopier result: " + string);
        string = lReplacer(string);
        System.out.println("lReplacer result: " + string);
        
        System.out.print("How many replacements? ");
        Scanner scanner = new Scanner(System.in);
        
        for(int i = scanner.nextInt(); i > 0; i--)
            string = lMultiplier(string);
        scanner.close();
        
        System.out.println("Hold these L's: " + string);

    }

}
