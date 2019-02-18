package OM.DiceGame;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Olivier on 6/21/2017.
 */
public class GameInstance {
    private double MoneyPot = 0.50;
    public double GetMoneyPot(){
        return MoneyPot;
    }

    public void PlayRounds(int numberOfRounds){
        for(int iterations = 0; iterations < numberOfRounds; iterations++) {
            int dieOne = ThreadLocalRandom.current().nextInt(1, 7);
            int dieTwo = ThreadLocalRandom.current().nextInt(1, 7);
            AllocateWinnings(dieOne + dieTwo);
        }
    }

    private void AllocateWinnings(int sum){
        try {
            if (sum <= 6) {
                MoneyPot -= 0.50;
            } else if (6 < sum && sum <= 9) {
                //Do Nothing
            } else if (sum == 10) {
                MoneyPot += 0.50;
            } else if (sum == 11) {
                MoneyPot += 1.00;
            } else if (sum == 12) {
                MoneyPot += 1.50;
            } else {
                throw new IOException();
            }

        } catch (IOException e) {
            System.out.println("There was an error playing the round, the money pot remains unchanged, however game should be checked for fairness");
        }
    }
}
