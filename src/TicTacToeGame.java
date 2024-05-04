import Entities.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class TicTacToeGame {

    Deque<User> Players;
    Board game;


    public void initialize_game()
    {
        Players = new LinkedList<>();
        PlayingPiece crossPiece = new PieceTypeX();
        User player1 = new User("101", "Player1", crossPiece);

        PlayingPiece noughtsPiece = new PieceTypeO();
        User player2 = new User("102","Player2", noughtsPiece);

        Players.add(player1);
        Players.add(player2);

        //initializeBoard
        game = new Board(3);


    }

    public String StartGame()
    {
        boolean noWinner = true;
        while(noWinner) {

            User UserWhoGetsAChance = Players.removeFirst();
            game.printBoard();
            List<Pair<Integer, Integer>> freeSpaces =  game.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            
            System.out.print("Player:" + UserWhoGetsAChance.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            boolean res = game.addPieceToBoard(inputRow, inputColumn, UserWhoGetsAChance.p);
            if (res == false) {
                System.out.println("Already Selected, Please try again!");
                Players.addFirst(UserWhoGetsAChance);
                continue;
            }
            Players.addLast(UserWhoGetsAChance);
            boolean winner = isThereWinner(inputRow, inputColumn, UserWhoGetsAChance.p.p);
            if(winner) {
                return UserWhoGetsAChance.name;
            }


        }
        return "tie";

    }
    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<game.size;i++) {

            if(game.matrix_board[row][i] == null || game.matrix_board[row][i].p != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<game.size;i++) {

            if(game.matrix_board[i][column] == null || game.matrix_board[i][column].p != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<game.size;i++,j++) {
            if (game.matrix_board[i][j] == null || game.matrix_board[i][j].p != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=game.size-1; i<game.size;i++,j--) {
            if (game.matrix_board[i][j] == null || game.matrix_board[i][j].p != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }



}
