package ohtu;

public class TennisGame {
    
    private int player1Score;
    private int player2Score;
    private String player1Name;
    private String player2Name;
    private String scoreName;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.player1Score = 0;
        this.player2Score = 0;
        this.scoreName = "";
    }

    public void wonPoint(String winner) {
        if (winner == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            nameScoreWhenTie(player1Score);
        } else if (player1Score >= 4 || player2Score >= 4) {
            nameScoreWhenAtLeast4(player1Score-player2Score);
        } else {
            for (int i=1; i < 3; i++) {
                if (i==1) {
                    nameScoreWhenBetween1And3(player1Score);
                } else {
                    scoreName += "-";
                    nameScoreWhenBetween1And3(player2Score);
                }
            }
        }
        return scoreName;
    }
    
    public void nameScoreWhenTie(int score) {
        switch (score) {
            case 0:
                scoreName = "Love-All";
                break;
            case 1:
                scoreName = "Fifteen-All";
                break;
            case 2:
                scoreName = "Thirty-All";
                break;
            case 3:
                scoreName = "Forty-All";
                break;
            default:
                scoreName = "Deuce";
                break;
        }
    }
    
    public void nameScoreWhenAtLeast4(int score) {
        if (score==1) {
            scoreName = "Advantage player1";
        } else if (score == -1) {
            scoreName = "Advantage player2";
        } else if (score >= 2) {
            scoreName = "Win for player1";
        } else {
            scoreName = "Win for player2";
        }
    }
    
    public void nameScoreWhenBetween1And3(int score) {
        switch(score) {
            case 0:
                scoreName += "Love";
                break;
            case 1:
                scoreName += "Fifteen";
                break;
            case 2:
                scoreName += "Thirty";
                break;
            case 3:
                scoreName += "Forty";
                break;
        }
    }
}