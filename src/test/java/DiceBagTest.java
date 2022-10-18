import Model.Stats.DiceBag;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiceBagTest {
    @Test
    public void rolld20_test(){
        int diceType = 20;
        assertTrue(DiceBag.rollDice(20) > 0 && DiceBag.rollDice(20) < 21);
    }
}
