package blackjack;

public class Player {
    private String Name;
    private int Score;
    Card Arr_of_cards []=new Card[11];
    private boolean got_BJ =false;
    private boolean lost =true;

    public Player() {
    }

    public Player(Player p) {
        this.Name=p.Name;
        this.Score=p.Score;
        for(int i=0;i<Arr_of_cards.length;i++)
        {
            this.Arr_of_cards[i]=p.Arr_of_cards[i];
        }
        this.got_BJ=p.got_BJ;
        this.lost= p.lost;
    }

    public void setName(String name)
    {
        Name = name;
    }

    public void setScore(int score)
    {
        Score = score;
    }
    public void setArr_of_cards(Card c,int idx)
    {
        Arr_of_cards[idx]=c;
    }

    public void setGot_BJ(boolean got_BJ)
    {
        this.got_BJ = got_BJ;
    }

    public void setLost(boolean lost)
    {
        this.lost = lost;
    }


    public String getName()
    {
        return Name;
    }

    public int getScore()
    {
        return Score;
    }

    public Card getArr_of_cards(int idx)

    {
       return Arr_of_cards[idx];
    }

    public boolean isGot_BJ()
    {
        return got_BJ;
    }

    public boolean isLost()
    {
        return lost;
    }

}
