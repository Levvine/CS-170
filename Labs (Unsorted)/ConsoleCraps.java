// SUBMITTED BY: ALAN HUANG
// HELPED BY: MATT SAMS (HE REMINDED ME TO PUT A TRUCKING TITLE)
// SO I DIDNT LOSE 5 POINTS

import java.util.Random;

public class ConsoleCraps {

    public static void main(String[] args) {
        
               
        Random random = new Random();
        int dice1 = random.nextInt(5) + 1;
        int dice2 = random.nextInt(5) + 1;
        int roll = dice1 + dice2;
        
        System.out.println("1st Roll = " + roll);
        
        if ((roll == 7) || (roll == 12))
            System.out.println("WIN!");
        else if ((roll == 2) || (roll == 3) || (roll == 12))
            System.out.println("LOSE!");
        else {
            int point = roll;
            roll = 0;
            System.out.println("Point = " + point);
            
            while (point != roll) {
                                
                dice1 = random.nextInt(5) + 1;
                dice2 = random.nextInt(5) + 1;
                roll = dice1 + dice2;
                System.out.println("Roll = " + roll);
                if (point == roll) {
                    System.out.println("WIN!");
                    break;
                }
                if (point == 7) {
                    System.out.println("LOSE!");
                    break;
                }
                
            }
        }
    }   
      
}
