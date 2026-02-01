public class Player {
    private int pickOrder;
    private Character bannedCharacter;

    public Player(int pickOrder) {

        this.pickOrder = pickOrder;
    }


    public Character banCharacter() {


        this.bannedCharacter = CharacterPool.getCharacter();
        return bannedCharacter;
    }

    
    public int getPickOrder() {

        return pickOrder;
    }


    public Character getBannedCharacter() {

        return bannedCharacter;
    }

}
