import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Character_test {
    @Test
    public void createCharacterTest() throws IOException {
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "Batman";
            }

            public int getMovementSpeed() {
                return 30;
            }

            public List<String> getRaceActions() {
                return null;
            }
        },
        new Barbarian(),
    null,
null);

        assertEquals(character.getName(), "Gregg");

    }
}
