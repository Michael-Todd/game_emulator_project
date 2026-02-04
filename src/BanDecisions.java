import java.util.*;

public class BanDecisions {
    private HashMap<Character, Integer> teamVotes1 = new HashMap<>();
    private HashMap<Character, Integer> teamVotes2 = new HashMap<>();
    private Integer max;
    private ArrayList<Character> bannedCharacters = new ArrayList<>();

    
    public BanDecisions(Pick[] team1, Pick[] team2) {

        for (int i=0; i<team1.length; i++) {
            if (teamVotes1.containsKey(team1[i].character())) {
                teamVotes1.put(team1[i].character(), teamVotes1.get(team1[i].character())+1);
            }
            else {
                teamVotes1.put(team1[i].character(), 1);
            }
        }

        for (int i=0; i<team2.length; i++) {
            if (teamVotes2.containsKey(team2[i].character())) {
                teamVotes2.put(team2[i].character(), teamVotes2.get(team2[i].character())+1);
            }
            else {
                teamVotes2.put(team2[i].character(), 1);
            }
        }



    }
}
