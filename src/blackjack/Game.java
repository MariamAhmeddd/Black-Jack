package blackjack;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player Arr_of_players [] = new Player[4];
    Card deck [] = new Card[52];
    private int i;
    private int Max_score=0;
    /*public Game() {
        i=0;
        deck=new Card[52];
    }*/

    public int getMax_score() {
        return Max_score;
    }

    public Player getArr_of_players(int idx) {
        return Arr_of_players[idx];
    }

    public void setArr_of_players(Player p,int idx) {
        Arr_of_players[idx]=p;
    }

    private int shape=0;
    private int cnt=4;
    void generate ()
    {
        while (cnt>0)
        {
            for(int ii=0;ii<13;ii++)
            {
                if(ii<10)
                {
                    Card c=new Card(shape,ii,ii+1);
                    deck[i]=c;
                }
                else
                {
                    Card c=new Card(shape,ii,10);
                    deck[i]=c;
                }
                i++;
            }
            shape++;
            cnt--;
        }
    }
    Card random()
    {
        Card c_copy;
        Random rand =new Random();
        while (true)
        {
            int randomChoice = rand.nextInt(52);
            if(deck[randomChoice]!=null)
            {
                c_copy=new Card(deck[randomChoice]);
                deck[randomChoice]=null;
                return c_copy;
            }
        }
    }
    void setPlayers()
    {
        GUI gui = new GUI();
        for (int j=0;j<4;j++)
        {
            Player p=new Player();
            if(j<3)
            {
                System.out.println("please enter the player's name");
                String name;
                Scanner in= new Scanner(System.in);
                name=in.next();
                p.setName(name);
            }
            else
            {
                p.setName("dealer");
            }
            int y=0;
            for(int i=0;i<2;i++)
            {
                Card c= new Card(random());
                p.setArr_of_cards(c,i);
                int x=c.getValue();
                y+=x;
            }
            p.setScore(y);
            Arr_of_players[j]=p;
            //maximum_score(y);
        }
        gui.runGUI(deck,Arr_of_players[0].Arr_of_cards,Arr_of_players[1].Arr_of_cards,Arr_of_players[2].Arr_of_cards,Arr_of_players[3].Arr_of_cards);
    }
    void maximum_score(int x)
    {
        if(x>Max_score&&x<=21)
        {
            Max_score=x;
        }
    }
    /*void out()
    {
        for (int j=0;j<52;j++)
        {
            System.out.println(deck[j].suit);
            System.out.println(deck[j].rank);
            System.out.println(deck[j].value);
            System.out.println("***********************");
        }
    }*/
    /*void outputplayers ()
    {
        for(int k=0;k<4;k++)
        {
            System.out.println(Arr_of_players[k].getName());
            System.out.println(Arr_of_players[k].getScore());
            for(int m=0;m<2;m++)
            {
                System.out.println(Arr_of_players[k].getArr_of_cards(m).getSuit());
                System.out.println(Arr_of_players[k].getArr_of_cards(m).getRank());
                System.out.println(Arr_of_players[k].getArr_of_cards(m).getValue());
            }
            System.out.println("*******************************");
        }
        System.out.println(Max_score);
    }*/

}
