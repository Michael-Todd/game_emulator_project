/**
 * Represents the building of the two competing player teams in the videogame.
 * TeamBuilder creates Player objects, groups them into teams, and ultimately grants access to a Pick array representing each team.
 */
public class TeamBuilder {
    private static final int TEAM_SIZE = 5;
    
    private Player[] playerList1 = new Player[TEAM_SIZE];
    private Player[] playerList2 = new Player[TEAM_SIZE];
    private Pick[] picks1 = new Pick[TEAM_SIZE];
    private Pick[] picks2 = new Pick[TEAM_SIZE];

    /**
     * Constructs a TeamBuilder object, each of which creates two random teams.
     * Each object is bound to be distinct from any other in terms of the contents of the Pick arrays representing each team.
     */
    public TeamBuilder() {

        makeTeam();

        populatePicks(playerList1, picks1);
        populatePicks(playerList2, picks2);
    }

    /**
     * Contains the logic to construct an array of Player objects, the Players that make up a team.
     */
    private void makeTeam() {
        for (int i=0; i<TEAM_SIZE; i++) {
            playerList1[i] = new Player(i+1);
            playerList2[i] = new Player(i+1);
        }
    }

    /**
     * Contains the logic to construct an array of Pick type, representing the relevant data of a team.
     * 
     * @param playerList an array of Player objects as constructed by makeTeam
     * @param picks the Pick array to be populated
     */
    private void populatePicks(Player[] playerList, Pick[] picks) {
        for (int i=0; i<TEAM_SIZE; i++) {
            picks[i] = new Pick(playerList[i].banCharacter(), playerList[i].getPickOrder());
        }
    }
    
    /**
     * the Pick array representing the first team
     * 
     * @return the first team (relevant data: bannedCharacter vote, pickOrder)
     */
    public Pick[] getTeam1() {
        return picks1;
    }

    /**
     * the Pick array representing the second team
     * 
     * @return the second team (relevant data: bannedCharacter vote, pickOrder)
     */
    public Pick[] getTeam2() {
        return picks2;
    }
}

//note: through this design, the pick order is available through the array, so in that regard Player need not have a field for order (Pick[] arrays store their order)
//but maybe there is value in a Player object storing its order still; for now, keep it -- it might be used in point tallying further down or something
//also makes intent very clear -- it would be much less obvious if array index was used alone