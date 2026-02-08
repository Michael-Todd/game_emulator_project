public class Character {//creation of Characters lives solely in CharacterPool, where a fixed set of 12 Characters are made/stored
    private String name;

    public Character(String name) {

        this.name = name;
    }
    
    public String getName() {
        
        return name;
    }
}
