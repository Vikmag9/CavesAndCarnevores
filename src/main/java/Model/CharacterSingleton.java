package Model;

public final class CharacterSingleton {
    private Character character;
    private final static CharacterSingleton INSTANCE = new CharacterSingleton();

    private CharacterSingleton() {}

    public static CharacterSingleton getInstance() {
        return INSTANCE;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Character getCharacter() {
        return this.character;
    }
}
