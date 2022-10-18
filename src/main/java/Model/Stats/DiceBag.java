package Model.Stats;

import java.util.Random;

/**
 * A class that rolls a die given a diceType.
 */
public class DiceBag {
    /**
     * Method that chooses a random number between 1 and the diceType. So a d10 rolls a number between 1 and 10 for example.
     * @param diceType An int, either 4, 6, 8, 10, 12, or 20.
     * @return A random number between 1 and the diceType.
     */
    public static int rollDice(int diceType){
        Random rand = new Random();
        return switch (diceType) {
            case 4, 6, 8, 10, 12, 20 -> rand.nextInt(diceType) + 1;
            default -> throw new IllegalArgumentException("Dice type must be valid. Enter either 4, 6, 8, 10, 12, or 20.");
        };
    }
}


