public class Player {
    private int pickOrder;
    private Character bannedCharacter;

    public Player(Character bannedCharacter, int pickOrder) {
        
        this.bannedCharacter = bannedCharacter;
        this.pickOrder = pickOrder;
    }


    public void banCharacter(Character character) {

        this.bannedCharacter = character;
    }

    
    public int getPickOrder() {

        return pickOrder;
    }


    public Character getBannedCharacter() {

        return bannedCharacter;
    }

}
