import java.util.*;

public class BanDecisions {//responsible for using Pick[] teams accessed from TeamBuilder object to determine which Characters are banned and displaying said bans
    private HashMap<Character, Integer> teamVotes1 = new HashMap<>(); //banned Character, number of votes for team1
    private HashMap<Character, Integer> teamVotes2 = new HashMap<>(); //banned Character, number of votes for team2
    private Set<Character> bannedCharacters = new LinkedHashSet<>(); //chosen over ArrayList to prevent duplicates

    
    public BanDecisions(Pick[] team1, Pick[] team2) {

        tallyTeamVotes(team1, teamVotes1);
        tallyTeamVotes(team2, teamVotes2);

        findTeamBans(teamVotes1);
        findTeamBans(teamVotes2);

    }


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

    private void findTeamBans(HashMap<Character, Integer> teamVotes) {
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
        
        bannedCharacters.add(maxCharacter);
        teamVotes.remove(maxCharacter);

        max = 0;
        maxCharacter = null;
        for (Map.Entry<Character, Integer> entry: teamVotes.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }
        if (maxCharacter!= null) {
            bannedCharacters.add(maxCharacter);
            teamVotes.remove(maxCharacter);
        }
    }


    public void printBannedCharacters(){
        for (Character bannedCharacter: bannedCharacters) {
            System.out.println(bannedCharacter.getName() + " is banned.");
        }
    }
}