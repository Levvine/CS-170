// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.util.Scanner;

public class PascalsTriangle {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many rows? ");
        int rows = scanner.nextInt();
        scanner.close();
        
        int currentColumn;
        int num;
        int numerator;
        int denominator;
        
        for(int currentRow = 0; currentRow < rows; currentRow++) {
            
            currentColumn = 0;
            num = 1;
            numerator = currentRow;
            denominator = 1;
            
            while (currentColumn < currentRow + 1) {
                               
                System.out.print(num + "\t");
                
                //System.out.print(numerator + "/" + denominator + "\t"); //debugger
                
                //num *= (numerator / denominator);
                num = num * numerator / denominator;
                
                //System.out.print(num + "\t");
                
                numerator--;
                denominator++;                              
                currentColumn++;
                
            }
            
            System.out.println();
            
        }
        
    }
    
}
