public class Contract {
    private final Player player;
    private final Team team;
    private final String type;
    private final double value;

    public Contract(Player player, Team team, String type, double value) {
        this.player = player;
        this.team = team;
        this.type = type;
        this.value = value;
        player.setCurrentTeam(team);
        player.setCurrentType(type);
        player.setMarketValue(value);
        team.addPlayer(player);
    }

    public Player getPlayer() {
        return this.player;
    }

    public Team getTeam() {
        return this.team;
    }

    public String getType() {
        return this.type;
    }

    public double getValue() {
        return this.value;
    }
}
