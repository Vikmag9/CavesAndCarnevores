import Model.Stats.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class Stats_test {

    @Test
    void testArrayStrategy(){
        ArrayStrategy arrayStrategy = new ArrayStrategy();
        ArrayList<Integer> list = new ArrayList<>((List.of(15, 14, 13, 12, 10, 8)));
        Assertions.assertEquals(arrayStrategy.getListOfStats(), list);
    }
    // Checks that all generated stats are between 1-20, because the Nightmare strategy rolls 6 d20 dice.
    @Test
    void testNightmareStrategy(){
        NightmareStrategy nightmareStrategy = new NightmareStrategy();
        ArrayList<Integer> listOfStats = new ArrayList<>(nightmareStrategy.getListOfStats());
        for (Integer stat : listOfStats) Assertions.assertTrue(stat >= 1 && stat <= 20);
    }

    // Tests that every stat in the list rolled with RollStrategy is between 3-18, because that is the minimum and maximum sum that
    // 3 d6 dice can produce.
    @Test
    void testRollStrategy(){
        RollStrategy rollStrategy = new RollStrategy();
        ArrayList<Integer> listOfStats = new ArrayList<>(rollStrategy.getListOfStats());
        for (Integer stat : listOfStats) Assertions.assertTrue(stat >= 3 && stat <= 18);
    }

    // Tests that all valid dice types returns a value between 1-diceType. Also tests that an invalid diceType should
    // throw an IllegalArgumentException.
    @Test
    public void rollDifferentDice_test(){
        int d4 = 4;
        int d6 = 6;
        int d8 = 8;
        int d10 = 10;
        int d12 = 12;
        int d15 = 15;
        int d20 = 20;
        Assertions.assertTrue(DiceBag.rollDice(d4) >= 1 && DiceBag.rollDice(d4) <= 4);
        Assertions.assertTrue(DiceBag.rollDice(d6) >= 1 && DiceBag.rollDice(d6) <= 6);
        Assertions.assertTrue(DiceBag.rollDice(d8) >= 1 && DiceBag.rollDice(d8) <= 8);
        Assertions.assertTrue(DiceBag.rollDice(d10) >= 1 && DiceBag.rollDice(d10) <= 10);
        Assertions.assertTrue(DiceBag.rollDice(d12) >= 1 && DiceBag.rollDice(d12) <= 12);
        Assertions.assertTrue(DiceBag.rollDice(d20) >= 0 && DiceBag.rollDice(d20) <= 20);
        Assertions.assertThrows(IllegalArgumentException.class, ()-> DiceBag.rollDice(d15));

    }

    @Test
    public void calculateModifier_test(){
        StatGenerator statGenerator = new StatGenerator();
        Assertions.assertEquals(statGenerator.getModifier(1), -5);
    }
}
