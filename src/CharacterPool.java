import java.util.Random;

public class CharacterPool {
    
    private static final String[] CHARACTERS = {
        "char1", "char2", "char3", "char4",
        "char5", "char6", "char7", "char8",
        "char9", "char10", "char11", "char12"
    };

    private Random rand = new Random();

    //chosen to be nonstatic in case future me wishes to work with multiple character pools
    public Character getCharacter() {

        String name = CHARACTERS[rand.nextInt(CHARACTERS.length)];
        return new Character(name);
    }
}
