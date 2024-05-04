public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initialize_game();
        System.out.println("game winner is: " + game.StartGame());

    }
}