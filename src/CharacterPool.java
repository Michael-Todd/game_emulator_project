import java.util.Random;

/**
 * Represents the set of playable characters in the videogame.
 * Static class that stores and returns Characters.
 */
public class CharacterPool {
    
    private static final Character[] CHARACTERS = {
        new Character("char1"), new Character("char2"), new Character("char3"), new Character("char4"),
        new Character("char5"), new Character("char6"), new Character("char7"), new Character("char8"),
        new Character("char9"), new Character("char10"), new Character("char11"), new Character("char12")
    };

    private static Random rand = new Random();

    /**
     * Randomly returns a Character object.
     * 
     * @return a Character object from the set of playable characters
     */
    public static Character getCharacter() {

        Character character = CHARACTERS[rand.nextInt(CHARACTERS.length)];
        return character;
    }
}
