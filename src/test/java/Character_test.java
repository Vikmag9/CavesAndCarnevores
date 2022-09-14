import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class Character_test {
    @Test
    void createCharacterTest() throws IOException {
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return "race here";
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
    }
}
