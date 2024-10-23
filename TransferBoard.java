
import java.util.ArrayList;

public class TransferBoard {

    private final ArrayList<Contract> contracts = new ArrayList<>();
    private final ArrayList<Player> players = new ArrayList<>();
    private final ArrayList<Team> teams = new ArrayList<>();

    public TransferBoard() {

    }

    public void initializePlayers() {
        players.add(new Player("Muslera", 1, "GoalKeeper"));
        players.add(new Player("Kaan", 22, "Defence"));
        players.add(new Player("Toreira", 34, "Midfield"));
        players.add(new Player("Icardi", 99, "Forward"));
        players.add(new Player("Kerem", 7, "Midfield"));
        players.add(new Player("Abdulkerim", 17, "Defence"));
        players.add(new Player("Oliveira", 20, "Midfield"));
        players.add(new Player("Mertens", 10, "Midfield"));
        players.add(new Player("Bakambu", 9, "Forward"));
        players.add(new Player("Nellson", 4, "Defence"));
        players.add(new Player("Boey", 2, "Defence"));
    }

    public void initializeTeams() {
        teams.add(new Team("Galatasaray", "GS"));
        teams.add(new Team("Fenerbahce", "FB"));
        teams.add(new Team("Besiktas", "BJK"));
        teams.add(new Team("Trabzonspor", "TS"));
        teams.add(new Team("Ankaragucu", "ANK"));
        teams.add(new Team("Basaksehir", "BSK"));
        teams.add(new Team("Karagumruk", "KGM"));
    }

    public String makeContract(String playerName, String teamName, String contractType, double contractValue) {
        Player player = findPlayer(playerName);
        Team team = findTeam(teamName);

        if (player == null) {
            return "UnknownPlayer";
        } else if (team == null) {
            return "UnknownTeam";
        } else if (team.getSize() >= 22) {
            return "ExceedingMaxNumPlayers";
        }

        Contract existingContract = findContract(playerName, teamName);
        if (existingContract != null) {
            return "ExistingContract";
        } else if (!isValidContractType(contractType)) {
            return "InvalidContractType";
        } else if (player.getMarketValue()>contractValue) {
            return "TheContractValuesIsBelowPlayerMarketValue";
        }
        else if (contractNotPossible(player)) {
            return "ContractNotPossible";
        }

        terminateExistingContract(playerName);

        contracts.add(new Contract(player, team, contractType, contractValue));
        return "SuccessfullyContracted";
    }

    private boolean isValidContractType(String contractType) {
        return contractType.equals("Permanent") || contractType.equals("Rented");
    }

    private boolean invalidContractType(Player player, String contractType) {
        return player.getCurrentType() != null && !contractType.equals("Permanent");
    }

    private boolean contractNotPossible(Player player) {
        return player.getCurrentType() != null && player.getCurrentType().equals("Rented");
    }

    private void terminateExistingContract(String playerName) {
        Contract existingContract = findContract(playerName);
        if (existingContract != null) {
            Team team = existingContract.getTeam();
            team.removePlayer(existingContract.getPlayer());
            contracts.remove(existingContract);
        }
    }

    public void terminateContract(String playerName, String teamName) {
        Contract contract = findContract(playerName, teamName);
        if (contract != null) {
            Player player = contract.getPlayer();
            Team team = contract.getTeam();
            contracts.remove(contract);
            team.removePlayer(player);
            if (player.getPreviousTeam() != null) {
                contracts.add(new Contract(player, player.getPreviousTeam(), "Permanent", player.getPreviousMarketValue()));
                player.terminatePreviousValues();
            } else {
                player.terminateAllValues();
            }
        } else {
            System.out.println("Contract does not exist.");
        }
    }

    private Contract findContract(String playerName, String teamName) {
        for (Contract contract : contracts) {
            if (contract.getPlayer().getName().equals(playerName) && contract.getTeam().getFullName().equals(teamName)) {
                return contract;
            }
        }
        return null;
    }

    private Contract findContract(String playerName) {
        for (Contract contract : contracts) {
            if (contract.getPlayer().getName().equals(playerName)) {
                return contract;
            }
        }
        return null;
    }

    private Player findPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    private Team findTeam(String fullName) {
        for (Team team : teams) {
            if (team.getFullName().equals(fullName)) {
                return team;
            }
        }
        return null;
    }

    public void printTeamlessPlayers() {
        for (Player player : players) {
            if (player.getCurrentTeam() == null) {
                System.out.println(player);
            }
        }
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public void printTeams() {
        for (Team team : teams) {
            System.out.println(team);
        }
    }

    public void print() {
        System.out.println("Each player with a contract:");

        for (Contract contract : contracts) {
            Player currentPlayer = contract.getPlayer();
            System.out.println(currentPlayer.getName() + " : " + currentPlayer.getMarketValue() + " - " + currentPlayer.getCurrentTeam());
        }

        System.out.println("Each team:");

        for (Team team : teams) {
            System.out.println(team.getShortName() + " : " + team.getTotalValue() + " - " + team.getSize());
        }

        System.out.println("Each player without a contract: ");

        for (Player player : players) {
            if (findContract(player.getName()) == null) {
                System.out.println(player.getName());
            }
        }
    }
}
