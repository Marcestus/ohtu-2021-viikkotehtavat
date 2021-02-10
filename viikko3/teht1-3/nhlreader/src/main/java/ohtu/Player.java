
package ohtu;

import java.util.Comparator;

public class Player {
    private String name;
    private String nationality;
    private String team;
    private int goals;
    private int assists;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public int getPoints() {
        return this.goals + this.assists;
    }

    public static Comparator<Player> playerPoints = new Comparator<Player>() {
        @Override
        public int compare(Player p1, Player p2) {
            int points1 = p1.getPoints();
            int points2 = p2.getPoints();
            
            return points2-points1;
        }
    };
    
    @Override
    public String toString() {
        return String.format("%-20s",name) + String.format("%-5s", team) + " " + String.format("%2d", goals) + " + " + String.format("%2d", assists) + " = " + String.format("%2d", this.getPoints());
    }
    
    public String task1() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
