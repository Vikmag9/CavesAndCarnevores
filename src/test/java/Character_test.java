import java.io.IOException;
import java.util.List;

public class Character_test {
    @Test
    void createCharacterTest() throws IOException {
        Character character = new Character("Gregg", new Race() {
            public String getRaceName() {
                return null;
            }

            public int getMovementSpeed() {
                return 0;
            }

            public List<String> getRaceActions() {
                return null;
            }
        }, new Barbarian(), new List, new InventoryItem("Consumable", ));
    }
}
