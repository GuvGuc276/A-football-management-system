import java.util.ArrayList;

public class Team {
    private final String shortName;
    private final String fullName;
    public final int MAX_TEAM_SIZE = 22;
    private final ArrayList<Player> players;

    public Team(String fullName, String shortName) {
        this.shortName = shortName;
        this.fullName = fullName;
        this.players = new ArrayList();
    }

   
    public String getFullName() {
        return this.fullName;
    }
    public void removePlayer(Player player) {
        this.players.remove(player);
    }
    public void addPlayer(Player player) {
        this.players.add(player);
    }
 
    public String getShortName() {
        return this.shortName;
    }

    public double getTotalValue() {
        double totalValue = 0.0;

        for(int i = 0; i < this.players.size(); ++i) {
            totalValue += ((Player)this.players.get(i)).getMarketValue();
        }

        return totalValue;
    }

    public int getSize() {
        return this.players.size();
    }

    public String toString() {
        String st = this.shortName;
        return "shortName='" + st + "\t, fullName='" + this.fullName + ",\t totalValue=" + this.getTotalValue() + ",\t size=" + this.getSize();
    }
}

