import Stats.ArrayStrategy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

public class Stats_test {

    @Test
    void testArrayStrategy(){
        ArrayStrategy arrayStrategy = new ArrayStrategy();
        ArrayList<Integer> list = new ArrayList<Integer>((List.of(15, 14, 13, 12, 10, 8)));
        assertTrue(Objects.equals(arrayStrategy.getListOfStats(), list));
    }
}
