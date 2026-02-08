import java.util.*;

/**
 * Represents tha process of making the ban decisions based on the two team's choices.
 * Responsible for using the Pick teams accessed from a TeamBuilder object to determined which Characters are banned for the match.
 * Displays these Characters.
 */
public class BanDecisions {
    private HashMap<Character, Integer> teamVotes1 = new HashMap<>(); //banned Character, number of votes for team1
    private HashMap<Character, Integer> teamVotes2 = new HashMap<>(); //banned Character, number of votes for team2
    private Set<Character> bannedCharacters = new LinkedHashSet<>(); //chosen over ArrayList to prevent duplicates

    /**
     * Constructs a BanDecisions object given two teams.
     * 
     * @param team1 the first team as returned by a TeamBuilder object
     * @param team2 the second team as returned by the same TeamBuilder object
     */
    public BanDecisions(Pick[] team1, Pick[] team2) {

        tallyTeamVotes(team1, teamVotes1);
        tallyTeamVotes(team2, teamVotes2);

        findTeamBans(teamVotes1);
        findTeamBans(teamVotes2);

    }

    /**
     * Tracks the number of votes from a team for each voted Character.
     * 
     * @param team a team as returned by a TeamBuilder object
     * @param teamVotes a HashMap to keep track of the number of votes casted for each Character
     */
    private void tallyTeamVotes(Pick[] team, HashMap<Character, Integer> teamVotes) {
        for (int i=0; i<team.length; i++) {
            if (teamVotes.containsKey(team[i].character())) {
                teamVotes.put(team[i].character(), teamVotes.get(team[i].character())+1);
            }
            else {
                teamVotes.put(team[i].character(), 1);
            }
        }
    }

    /**
     * Determines the Characters that are banned.
     * 
     * @param teamVotes the HashMap of ban votes as returned from tallyTeamVotes
     */
    private void findTeamBans(HashMap<Character, Integer> teamVotes) {
        banTopVotedCharacter(teamVotes);
        banTopVotedCharacter(teamVotes);
    }

    /**
     * Determines one of the Characters that are banned.
     * 
     * @param teamVotes the HashMap of ban votes as returned from talleyTeamVotes
     */
    private void banTopVotedCharacter(HashMap<Character, Integer> teamVotes) {
        Integer max = 0;
        Character maxCharacter = null;

        for (Map.Entry<Character, Integer> entry: teamVotes.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }

        if (maxCharacter != null) {// this is a guard in the case that all Players picked the same Character to ban, and is only really needed for the second call
            bannedCharacters.add(maxCharacter);
            teamVotes.remove(maxCharacter);
        }
    }

    /**
     * Prints the Characters that are banned.
     */
    public void printBannedCharacters(){
        for (Character bannedCharacter: bannedCharacters) {
            System.out.println(bannedCharacter.getName() + " is banned.");
        }
    }
}