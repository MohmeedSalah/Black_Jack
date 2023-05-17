package blackjack;

public class Player {
    String name;
    int score = 0;
    boolean check_loser = false;
    Card arr[] = new Card[11];
    int count = 2;


    public Player() {
        for (int j = 0; j < 11; j++) {
            arr[j] = new Card(0,0,0);
        }

    }
}
