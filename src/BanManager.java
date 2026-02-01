public class BanManager { //class meant to group players together and determine bans
    private static final int TEAM_SIZE = 5;
    
    private Player[] playerList1 = new Player[TEAM_SIZE];
    private Player[] playerList2 = new Player[TEAM_SIZE];
    private Pick[] picks1 = new Pick[TEAM_SIZE];
    private Pick[] picks2 = new Pick[TEAM_SIZE];

    public BanManager() {

        for (int i=0; i<TEAM_SIZE; i++) {
            playerList1[i] = new Player(i+1);
            playerList2[i] = new Player(i+1);
        }

        populatePicks(playerList1, picks1);
        populatePicks(playerList2, picks2);
    }

    private void populatePicks(Player[] playerList, Pick[] picks) {
        for (int i=0; i<TEAM_SIZE; i++) {
            picks[i] = new Pick(playerList[i].banCharacter(), playerList[i].getPickOrder());
        }
    }
}
