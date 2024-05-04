package Entities;

import java.util.ArrayList;


import java.util.List;

public class Board {

    public int size;
    public PlayingPiece[][] matrix_board;

    public Board(int size)
    {
        this.size=size;
        matrix_board = new PlayingPiece[size][size];

    }

    public boolean addPieceToBoard(int i, int j, PlayingPiece p)
    {
        if(matrix_board[i][j]==null)
        {
            matrix_board[i][j] = p;
            return true;

        }
        return false;
    }

    public List<Pair<Integer, Integer>> getFreeCells()
    {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                if(matrix_board[i][j]==null)
                {
                    Pair<Integer, Integer> freeCell = new Pair<>(i, j);
                    freeCells.add(freeCell);
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix_board[i][j] != null) {
                    System.out.print(matrix_board[i][j].p.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }


}
