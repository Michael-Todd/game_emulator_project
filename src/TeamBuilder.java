public class TeamBuilder { //class meant to group players together and determine ban votes
    private static final int TEAM_SIZE = 5;
    
    private Player[] playerList1 = new Player[TEAM_SIZE];
    private Player[] playerList2 = new Player[TEAM_SIZE];
    private Pick[] picks1 = new Pick[TEAM_SIZE];
    private Pick[] picks2 = new Pick[TEAM_SIZE];

    public TeamBuilder() {

        System.out.println("TeamBuilder running..");

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
    } //to fill picks1 and picks2 using the Players from playerList1 and playerList2 and the instance method banCharacter

    public Pick[] getTeam1() {
        return picks1;
    }

    public Pick[] getTeam2() {
        return picks2;
    }
}

//note: through this design, the pick order is available through the array, so in that regard Player need not have a field for order (Pick[] arrays store their order)
//but maybe there is value in a Player object storing its order still; for now, keep it -- it might be used in point tallying further down or something
//also makes intent very clear -- it would be much less obvious if array index was used alone