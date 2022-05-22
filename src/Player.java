import java.util.ArrayList;

public class Player {

    private String nickname;

 //   private int health = 20;

    private int score = 0;


    static ArrayList<Player> TopPlayers = new ArrayList<>();


    Player(String nickname)
    {

        this.nickname = nickname;
        TopPlayers.add(this);


    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public String toString()
    {
        return "NickName: "+this.nickname +
                "Score: "+ this.score;
    }


}
