package OM.DiceGame;

public class Main {

    public static void main(String[] args) {
	    GameInstance game = new GameInstance();
	    game.PlayRounds(1000);
        System.out.println("After 1000 iterations, the money pot is: " + game.GetMoneyPot());
        if(game.GetMoneyPot() < 0){
            System.out.println("This game is bad for you, please stop playing");
        }
        else{
            System.out.println("Congratulations, you've actually made a profit somehow");
        }

    }
}
