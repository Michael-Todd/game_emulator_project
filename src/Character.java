/**
 * Represents a character in the videogame.
 * Each Character has a name.
 * *Note that there is a static list of Characters, which is stored and handled by the class CharacterPool
 */
public class Character {
    private String name;

    /**
     * Constructs a Character object with its name.
     * 
     * @param name the name of this Character object
     */
    public Character(String name) {

        this.name = name;
    }
    
    /**
     * Returns the name of this Character object.
     * 
     * @return the Character's name
     */
    public String getName() {
        
        return name;
    }
}
