package blackjack;

import java.util.Scanner;

public class BlackJack {
    static Game g= new Game();
    public static void main(String[] args) {
        GUI gui = new GUI();
        Scanner in=new Scanner(System.in);
        g.generate();
        g.setPlayers();
        for(int i=0;i<3;i++)
        {
            Player p=new Player(g.getArr_of_players(i));
            int num_of_cards=2;
            int a=p.getScore();
            System.out.println("its "+(i+1)+" turn");
            boolean done=false;
            while(!done)
            {
                int x;
                System.out.println("please enter your choice");
                System.out.println("Score of "+(i+1)+" is");
                System.out.println(a);
                /*if(p.getScore()>21)
                {
                    System.out.println("player "+(i)+" is busted");
                    done=true;
                    continue;
                }*/
                System.out.println("1-hit");
                System.out.println("2-stand");
                x=in.nextInt();
                if(x==1)
                {
                    Card c=new Card(g.random());
                    p.setArr_of_cards(c,num_of_cards);
                    a+=c.getValue();
                    if(a==21)
                    {
                        p.setGot_BJ(true);
                        p.setLost(false);
                        p.setScore(a);
                        done=true;
                    }
                    else if(a>21)
                    {
                        p.setLost(true);
                        p.setScore(a);
                        done=true;
                        System.out.println("player "+(i+1)+" is busted");
                    }
                    num_of_cards++;
                    gui.updatePlayerHand(c,i);
                }
                else
                {
                    p.setScore(a);
                    done=true;
                    System.out.println("player "+(i+1)+"'s score "+(p.getScore()));
                }
            }
            g.setArr_of_players(p,i);
            g.maximum_score(p.getScore());
            System.out.println("maximum score is  "+(g.getMax_score()));
        }
        Player dealer =new Player(g.getArr_of_players(3));
        if(dealer.getScore()==21)
        {
            dealer.setGot_BJ(true);
            dealer.setLost(false);
            g.setArr_of_players(dealer,3);
            g.maximum_score(dealer.getScore());
        }
        else if(dealer.getScore()>21)
        {
            dealer.setLost(true);
            g.setArr_of_players(dealer,3);
            g.maximum_score(dealer.getScore());
        }
        else if(dealer.getScore()>g.getMax_score())
        {
            dealer.setLost(false);
            g.setArr_of_players(dealer,3);
            g.maximum_score(dealer.getScore());
        }
        else
        {
            boolean dealer_is_done = false;
            int num_of_cards=2;
            int a=dealer.getScore();
            System.out.println("its dealer's turn");
            while (!dealer_is_done)
            {
                Card c=new Card(g.random());
                dealer.setArr_of_cards(c,num_of_cards);
                a+=c.getValue();
                if(a>21)
                {
                    dealer.setLost(true);
                    dealer.setScore(a);
                    dealer_is_done=true;
                }
                else if(a==21)
                {
                    dealer.setGot_BJ(true);
                    dealer.setLost(false);
                    dealer_is_done=true;
                    dealer.setScore(a);
                }
                gui.updateDealerHand(c,g.deck);
            }
            g.setArr_of_players(dealer,3);
            g.maximum_score(dealer.getScore());
        }
        //System.out.println("dealer score"+(g.getArr_of_players(3).getScore()));
        //System.out.println(g.getMax_score());
        int cnt=0;
        System.out.println("the winner which has score "+(g.getMax_score())+" : ");
        for(int l=0;l<4;l++)
        {
            if(g.getMax_score()==g.getArr_of_players(l).getScore())
            {
                System.out.println(g.getArr_of_players(l).getName());
                cnt++;
            }
        }
        if(cnt>=2)
        {
            System.out.println("PUSH");
        }
        if(cnt==1)
        {
            System.out.println("BLACK JACK");
        }
    }
}
