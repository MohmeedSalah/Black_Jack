package blackjack;
import java.util.Random;
public class Game {

    Player arr_player[] = new Player[4];
    Card arr_card[] = new Card[52];
    Card arr_card_taken[] = new Card[52];
    int RandChoice;

    public Game() {
        for(int i = 0;i < 4;i++)
            arr_player[i] = new Player();
    }

    public Card draw() {
        Random Rand = new Random();
        RandChoice = Rand.nextInt(52);
        while(arr_card[RandChoice] == null) {
            RandChoice = Rand.nextInt(52);
        }
        arr_card_taken[RandChoice] = arr_card[RandChoice];
        arr_card[RandChoice] = null;
        return arr_card_taken[RandChoice];
    }
    public void set_information(String name, int i) {
        arr_player[i].name = name;
        arr_player[i].arr[0] = draw();
        arr_player[i].arr[1] = draw();
        arr_player[i].score += arr_player[i].arr[0].getValue();
        arr_player[i].score += arr_player[i].arr[1].getValue();
    }

    public void update(int i , int j) {
        arr_player[i].score += arr_player[i].arr[j].getValue();
        arr_player[i].count++;
    }

    public void card_number() {
        for (int i = 0; i <= 12; i++) {
            int rank_card, value_card;
            if (i == 9 || i == 10 || i == 11 || i == 12) {
                rank_card = 9;
            } else {
                rank_card = i;
            }
            value_card = i ;
            arr_card[i] = new Card(0, value_card , rank_card + 1);
        }
        for (int i = 13; i <= 25; i++) {
            int rank_card, value_card;
            if (i == 9 + 13 || i == 10 + 13 || i == 11 + 13 || i == 12 + 13) {
                rank_card = 9;
            } else {
                rank_card = i - 13;
            }
            value_card = i - 13;
            arr_card[i] = new Card(1, value_card, rank_card + 1);
        }
        for (int i = 26; i <= 38; i++) {
            int rank_card, value_card ;

            if (i == 9 + 26 || i == 10 + 26 || i == 11 + 26 || i == 12 + 26) {
                rank_card = 9;
            } else {
                rank_card = i - 26;
            }
            value_card = i - 26;
            arr_card[i] = new Card(2, value_card, rank_card + 1);
        }
        for (int i = 39; i <= 51; i++) {
            int rank_card, value_card;
            if (i == 9 + 39 || i == 10 + 39 || i == 11 + 39 || i == 12 + 39) {
                    rank_card = 9;
            } else {
                rank_card = i - 39;
            }
            value_card = i - 39;
            arr_card[i] = new Card(3, value_card, rank_card + 1);
        }
    }}
