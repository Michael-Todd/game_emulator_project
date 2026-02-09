public class Main {

    public static void main(String[] args) {

        TeamBuilder teamBuilder = new TeamBuilder();
        Pick[] team1 = teamBuilder.getTeam1();
        Pick[] team2 = teamBuilder.getTeam2();

        for (Pick pick: team1) {
            System.out.println("From the first team, ban pick " + pick.pickOrder() + " is " + pick.character().getName());
        }

        System.out.println();

        for (Pick pick: team2) {
            System.out.println("From the second team, ban pick " + pick.pickOrder() + " is " + pick.character().getName());
        }

        System.out.println("--------------------------------------------");
        BanDecisions banDecisions = new BanDecisions(team1, team2);
        banDecisions.printBannedCharacters();
    }
}