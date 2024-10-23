import java.util.Random;
public class Player {
    private final int backNumber;
    private String name;
    private String position;
    private double marketValue;
    private Team currentTeam;
    private Team previousTeam;
    private int totalGoals;
    private int totalYellowCards;
    private String currentType;
    private String previousType;
    private double previousMarketValue;

    public Player(String name, int backNumber, String position) {
        double r1 = new Random().nextDouble(100001);
        this.name = name;
        this.backNumber = backNumber;
        this.position = position;
        this.marketValue = ((int)(r1*100))/100.0;
        this.currentTeam = null;
        this.previousTeam = null;
        this.totalGoals = new Random().nextInt(25);
        this.totalYellowCards = new Random().nextInt(10);
        this.currentType = null;
        this.previousType = null;
    }
    public void setCurrentType(String currentType) {
        this.setPreviousType(this.currentType);
        this.currentType = currentType;
    }
    public String getCurrentType() {
        return this.currentType;
    }
    public void terminateAllValues() {
        this.marketValue = 0.0;
        this.currentTeam = null;
        this.currentType = null;
        this.terminatePreviousValues();
    }
     public void terminatePreviousValues() {
        this.previousType = null;
        this.previousTeam = null;
        this.previousMarketValue = 0.0;
    }


    public String getPreviousType() {
        return this.previousType;
    }

    public Team getCurrentTeam() {
        return this.currentTeam;
    }

    public void setCurrentTeam(Team currentTeam) {
        this.setPreviousTeam(this.currentTeam);
        this.currentTeam = currentTeam;
    }

    public Team getPreviousTeam() {
        return this.previousTeam;
    }

    private void setPreviousTeam(Team previousTeam) {
        this.previousTeam = previousTeam;
    }

    public int getBackNumber() {
        return this.backNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return this.position;
    }
    private void setPreviousType(String previousType) {
        this.previousType = previousType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getMarketValue() {
        return this.marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.setPreviousMarketValue(this.marketValue);
        this.marketValue = marketValue;
    }

    public double getPreviousMarketValue() {
        return this.previousMarketValue;
    }

    private void setPreviousMarketValue(double previousMarketValue) {
        this.previousMarketValue = previousMarketValue;
    }

    public int getTotalGoals() {
        return this.totalGoals;
    }

    public void setTotalGoals(int totalGoals) {
        this.totalGoals = totalGoals;
    }

    public int getTotalYellowCards() {
        return this.totalYellowCards;
    }

    public void setTotalYellowCards(int totalYellowCards) {
        this.totalYellowCards = totalYellowCards;
    }

    public String toString() {
        return "name=" + this.name + ",\t backNumber=" + this.backNumber + ",\t position=" + this.position + ",\t totalGoals=" + this.totalGoals + ",\t totalYellowCards=" + this.totalYellowCards + ",\t marketValue=" + this.marketValue;
    }
}
