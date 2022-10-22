package Model.Stats;

import java.util.Random;

/**
 * This class contains all the logic required to roll a die in the application.
 */
public class DiceBag {
    /**
     * A method that rolls a random int between 1 and the diceType. Used when rolling stats in the Wizard.
     * @param diceType An integer: typically 4, 6, 8, 10, 12, or 20 (Dice types used in Dungeons & Dragons).
     * @return a random int between 1-diceType.
     */
    public static int rollDice(int diceType){
        Random rand = new Random();
        return rand.nextInt(diceType)+1; // Generates a random number between 1 and the max of the dice type.
    }

}


