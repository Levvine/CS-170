// SUBMITTED BY: ALAN HUANG
// HELPED BY: NOBODY

//import java.util.Arrays;
import java.util.Scanner;

public class ModeFinder {

    public static int[] stringToArray(String string) {
        
        Scanner scanner = new Scanner(string);
        int dim = 0;
        while(scanner.hasNextInt()) {
            dim++;
            scanner.nextInt();
        }
        scanner.close();
        int[] array = new int[dim];
        
        scanner = new Scanner(string);
        for (int i = 0; i < dim; i++)
            array[i] = scanner.nextInt();
        scanner.close();
        
        return array;
        
    }
    
    public static void exchange(int[] array, int x, int y) {
        
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
        
    }
    
    public static void selectionSort(int[] array) {
        
        int minPos;
        for (int i = 0; i < array.length; i++) {
            minPos = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[minPos])
                    minPos = j;
            exchange(array, i, minPos);
        }
        
    }
    
    public static void occurrenceCounter(int[][] frequencyTable) {
               
        int lastPos = 0;
        for (int i = 0; i < frequencyTable[0].length;) {
            //System.out.println("i = " + i + "length = " + frequencyTable[0].length);
            for (int j = i; (j < frequencyTable[0].length) && (frequencyTable[0][j] 
                 == frequencyTable[0][i]); j++) {
                //System.out.println("j = " + j);
                frequencyTable[1][i]++;
                lastPos = j;
            }
            //System.out.println("j looped @" + lastPos);
            i = lastPos + 1;
        }

    }
    
    public static void modePrint(int[][] table) {
        
        int maxOcc = table[1][0];
        int nModes = 1;
        for (int i = 1; i < table[0].length; i++) {
            if (table[1][i] > maxOcc) {
                maxOcc = table[1][i];
                nModes = 1;
            }
            else if (table[1][i] == maxOcc) {
                nModes++;
            }
        }
        
        System.out.println("There " + ((nModes == 1 ) ? "was " : "were ") + 
                           nModes + " mode" + ((nModes == 1) ? ":" : "s:"));
        
        for (int i = 0; nModes > 0; i++) {
            if (table[1][i] == maxOcc) {
                nModes--;
                System.out.print(table[0][i] + ((nModes > 0) ? ", " : ""));
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        System.out.print("Enter some number of integers, separated by spaces: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        scanner.close();
        int[] list = stringToArray(userInput);
        selectionSort(list);
        
        int[][] frequencyTable = new int[2][list.length];
        frequencyTable[0] = list;
        occurrenceCounter(frequencyTable);
        /*System.out.println(Arrays.toString(frequencyTable[0]) + 
                           Arrays.toString(frequencyTable[1]));*/
        
        
        // if more than one mode then there will be an s on modes
                
        //System.out.println(Arrays.toString(list));
        
        modePrint(frequencyTable);
       
        // System.out.println(scanner.nextInt() + arraySize);
        
    }
    
}
