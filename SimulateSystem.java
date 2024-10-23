
import java.util.Scanner;

public class SimulateSystem {

    public SimulateSystem() {
    }

    public static void main(String[] args) {
        TransferBoard tB = new TransferBoard();
        tB.initializePlayers();
        tB.initializeTeams();
        Scanner scn = new Scanner(System.in);

        while (true) {
            System.out.println("1- LIST ALL PLAYERS IN THE SYSTEM");
            System.out.println("2- LIST ALL TEAMS IN THE SYSTEM");
            System.out.println("3- LIST ALL THE TEAMLESS PLAYERS");
            System.out.println("4- BUILD A CONTRACT BETWEEN A TEAM AND A PLAYER");
            System.out.println("5- END A CONTRACT BETWEEN A TEAM AND A PLAYER");
            System.out.println("6- EXIT");
            int action = scn.nextInt();

            switch (action) {
                case 1:
                    tB.printPlayers();
                    break;
                case 2:
                    tB.printTeams();
                    break;
                case 3:
                    tB.printTeamlessPlayers();
                    break;
                case 4:
                    System.out.println("Enter player name:");
                    String playerName = scn.next();
                    System.out.println("Enter team name:");
                    String teamName = scn.next();
                    System.out.println("Enter contract type:");
                    String contractType = scn.next();
                    System.out.println("Enter contract value:");
                    double contractValue = scn.nextDouble();
                    System.out.println(tB.makeContract(playerName, teamName, contractType, contractValue));
                    break;
                case 5:
                    System.out.println("Enter player name:");
                    playerName = scn.next();
                    System.out.println("Enter team name:");
                    teamName = scn.next();
                    tB.terminateContract(playerName, teamName);
                    break;
                case 6:
                    tB.print();
                    return;
                default:
                    System.out.println("Please enter a valid action.");
                    break;
            }
        }
    }
}
