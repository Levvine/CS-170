// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

import java.util.Scanner;

public class FactorIntoPrimePowers {

    public static boolean isPrime(int n) {
        
        for(int i = 2; i <= Math.sqrt(n); i++) 
            if (n % i == 0)
                return false;
        return true;
                    
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(args[0]);
        int userInput = scanner.nextInt();
        scanner.close();
        int exponent;
        int count = 0;
        
        System.out.print("The prime factorization of " + userInput + " is ");
        
        for (int currentPrime = userInput / 2; currentPrime >= 2; currentPrime--)
            if (isPrime(currentPrime)) {
                exponent = 0;
                while (userInput % currentPrime == 0) {
                    exponent++;
                    userInput /= currentPrime;
                }
                switch (exponent) {
                case 0 : break;
                case 1 : System.out.print(count > 0 ? " * " : "");
                         System.out.print(currentPrime); count++; break;
                default : System.out.print(count > 0 ? " * " : "");
                          System.out.print(currentPrime + "^" + exponent); count++;
                }
            }
    }
}