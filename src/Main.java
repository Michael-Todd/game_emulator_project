public class Main {

    public static void main(String[] args) {

        TeamBuilder teamBuilder = new TeamBuilder();
        Pick[] team1 = teamBuilder.getTeam1();
        Pick[] team2 = teamBuilder.getTeam2();

        BanDecisions banDecisions = new BanDecisions(team1, team2);
        banDecisions.printBannedCharacters();
    }
}