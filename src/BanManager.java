public class BanManager { //class meant to group players together and determine bans
    private static final int TEAM_SIZE = 5;
    
    private Player[] playerList1 = new Player[TEAM_SIZE];
    private Player[] playerList2 = new Player[TEAM_SIZE];
    private Pick[] picks1 = new Pick[TEAM_SIZE];
    private Pick[] picks2 = new Pick[TEAM_SIZE];

    public BanManager() {

        for (int i=0; i<TEAM_SIZE; i++) {
            playerList1[i] = new Player(i+1);
        }

        for (int i=0; i<TEAM_SIZE; i++) {
            playerList2[i] = new Player(i+1);
        } //this block represents the loading of Players into teams


        for (int i=0; i<TEAM_SIZE; i++) {
            picks1[i] = new Pick(playerList1[i].banCharacter(), playerList1[i].getPickOrder());
        }

        for (int i=0; i<TEAM_SIZE; i++) {
            picks2[i] = new Pick(playerList2[i].banCharacter(), playerList2[i].getPickOrder());
        } //this block represents Players choosing their Character to ban, storing them along with their selection order
    
    }
}
