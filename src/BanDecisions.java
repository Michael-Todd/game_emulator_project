import java.util.*;

public class BanDecisions {
    private HashMap<Character, Integer> teamVotes1 = new HashMap<>(); //banned Character, number of votes for team1
    private HashMap<Character, Integer> teamVotes2 = new HashMap<>(); //banned Character, number of votes for team2
    private Integer max;
    private Character maxCharacter;
    private Set<Character> bannedCharacters = new LinkedHashSet<>(); //changed from ArrayList to prevent duplicates


    
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

        max = 0;
        maxCharacter = null;

        for (Map.Entry<Character, Integer> entry: teamVotes1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }

        bannedCharacters.add(maxCharacter);
        teamVotes1.remove(maxCharacter);

        max = 0;
        maxCharacter = null;

        for (Map.Entry<Character, Integer> entry: teamVotes1.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }

        if (maxCharacter != null) { //in the event that teamVotes1 consists of all the same keys, the second loop would never iterate, and maxCharacter would be null
            bannedCharacters.add(maxCharacter);
            teamVotes1.remove(maxCharacter); //in case I decide to ban more in the future, it makes sense to remove again
        }


        max = 0;
        maxCharacter = null;

        for (Map.Entry<Character, Integer> entry: teamVotes2.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }

        bannedCharacters.add(maxCharacter);
        teamVotes2.remove(maxCharacter);

        max = 0;
        maxCharacter = null;

        for (Map.Entry<Character, Integer> entry: teamVotes2.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                maxCharacter = key;
                max = value;
            }
        }

        if (maxCharacter != null) { //in the event that teamVotes1 consists of all the same keys, the second loop would never iterate, and maxCharacter would be null
            bannedCharacters.add(maxCharacter);
            teamVotes2.remove(maxCharacter); //in case I decide to ban more in the future, it makes sense to remove again
        }

    }
    public void printBannedCharacters(){
        for (Character bannedCharacter: bannedCharacters) {
            System.out.println(bannedCharacter + " is banned.");
        }
    }
}

//TODO: wrap repeated code blocks in constructor into private helper functions for readability's sake