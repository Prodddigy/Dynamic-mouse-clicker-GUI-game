import java.util.ArrayList;

public class Player {

    private String nickname;

    private int health = 20;

    private int score = 0;


    static ArrayList<Player> TopPlayers = new ArrayList<>();


    Player()
    {
        TopPlayers.add(this);


    }


    public void addPoints()
    {
       this.score +=1000;
    }

    public void setScore(int score) {
        this.score += score;
    }
}
