/**
 * Represents a player in the videogame.
 * Each Player has a pick order and votes for a Character to ban.
 */
public class Player {
    private int pickOrder;
    private Character bannedCharacter;

    /**
     * Constructs a Player object with a given pick order.
     * 
     * @param pickOrder the order in which this Player object is loaded into team
     */
    public Player(int pickOrder) {

        this.pickOrder = pickOrder;
    }

    /**
     * Randomly selects and returns a Character object using CharacterPool.
     * 
     * @return the Character object that this Player votes to ban
     */
    public Character banCharacter() {

        this.bannedCharacter = CharacterPool.getCharacter();
        return bannedCharacter;
    }

    /**
     * Returns the pick order for this Player.
     * 
     * @return the Player's pick order
     */
    public int getPickOrder() {

        return pickOrder;
    }

    /**
     * Returns the Character that this Player voted to ban.
     * 
     * @return the Player's ban vote
     */
    public Character getBannedCharacter() {

        return bannedCharacter;
    }

}
