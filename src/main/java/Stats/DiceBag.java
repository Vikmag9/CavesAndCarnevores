package Stats;

import java.util.Random;

public class DiceBag {

    public static int rollDice(int diceType){
        Random rand = new Random();
        return rand.nextInt(diceType)+1; // Generates a random number between 1 and the max of the dice type.
    }
}


