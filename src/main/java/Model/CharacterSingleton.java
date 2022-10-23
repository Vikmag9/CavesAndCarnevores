package Model;

public final class CharacterSingleton {
    private Character character;
    private final static CharacterSingleton INSTANCE = new CharacterSingleton();

    private CharacterSingleton() {}

    public static CharacterSingleton getInstance() {
        return INSTANCE;
    }

    public void setCharacter(Character u) {
        this.character = u;
    }

    public Character getCharacter() {
        return this.character;
    }
}
