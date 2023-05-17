package blackjack;

import javax.swing.text.Highlighter;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        GUI gui = new GUI();
        Scanner input = new Scanner(System.in);


        Player p1 = new Player();
        Game g1 = new Game();
        Card c1 = new Card(0,0,0);
        g1.card_number();

        for (int i = 0; i < 4; i++) {
            System.out.print("Enter Name PLayer " + i + "  : " );
            String name = input.next();
            g1.set_information(name, i);
            System.out.println(g1.arr_player[i].arr[0].getValue());
            System.out.println(g1.arr_player[i].arr[1].getValue());
            System.out.println("Score Player "+ i + " is "+g1.arr_player[i].score);
        }



        gui.runGUI(g1.arr_card , g1.arr_player[0].arr, g1.arr_player[1].arr, g1.arr_player[2].arr, g1.arr_player[3].arr);



        for (int i = 0; i < 3; i++) {
            for (int j = 2; j < 11; j++) {
                System.out.println("player "+ g1.arr_player[i].name +"Enter 1 to take card");
                if (g1.arr_player[i].score > 21) {
                    System.out.println("user is loser " + g1.arr_player[i].name + "\n\n\n");
                    break;
                }

                char statu = input.next().charAt(0);
                if (statu != '1' ) {
                    {
                        System.out.println("\n\n\n");
                        break;
                    }

                }
                g1.arr_player[i].arr[j] = g1.draw();
                gui.updatePlayerHand(g1.arr_player[i].arr[j],i);
                g1.update(i, j);
                System.out.println(g1.arr_player[i].arr[j].getValue());
                System.out.println("score is " + g1.arr_player[i].score);
            }

        }
        // 20 20 25
        boolean check = false;
        int highScore = 0;
        for (int i = 0;i < 3;i++) {
            if (g1.arr_player[3].score < g1.arr_player[i].score && g1.arr_player[i].score <= 21)
                check = true ;
            if (highScore < g1.arr_player[i].score && g1.arr_player[i].score <= 21)
                highScore = g1.arr_player[i].score;
        }
        if (check) {
            while (g1.arr_player[3].score < highScore) {
                g1.arr_player[3].arr[g1.arr_player[3].count] = g1.draw();
                g1.update(3, g1.arr_player[3].count);
                gui.updateDealerHand(g1.arr_player[3].arr[g1.arr_player[3].count - 1], g1.arr_card);
            }
        }
        if (!check)
            System.out.println(">>>>>>>>>>>>>>>         Dealer is Winner        <<<<<<<<<<<<<<<<<<<<");
        else if(g1.arr_player[3].score == 21) {
            System.out.println(">>>>>>>>>>>>>>>         Dealer is Winner        <<<<<<<<<<<<<<<<<<<<");
        }else {
            int High_score = 0 , high_index  = 0;
            boolean test = false ;
            for (int i = 0;i < 3;i++) {
                if (High_score < g1.arr_player[i].score && g1.arr_player[i].score <= 21) {
                    High_score = g1.arr_player[i].score;
                    high_index = i ;
                }
                else if (High_score == g1.arr_player[i].score)
                    test = true ;
            }
            if (test)
                System.out.println(">>>>>>>>>>>>>>>        PUSH          <<<<<<<<<<<<<<<<<");
            else if (High_score != 0)
                System.out.println("PLAYER " + g1.arr_player[high_index].name + " WINNER ");

        }
    }

}
