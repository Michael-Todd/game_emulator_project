import java.util.Random;

public class CharacterPool {
    
    private static final String[] CHARACTERS = {
        "char1", "char2", "char3", "char4",
        "char5", "char6", "char7", "char8"
    };

    private Random rand = new Random();

    public Character getCharacter() {

        String name = CHARACTERS[rand.nextInt(CHARACTERS.length)];
        return new Character(name);
    }
}
