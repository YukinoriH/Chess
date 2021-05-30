package main;
import main.chessPieces.*;

public class Chess{

    public static void main(String [] args){
        boardDisplay(initialState());
    }

    public static void boardDisplay(Piece[][] boardState){
        //8x8
        for(Piece[] row: boardState){
            for(Piece index: row){
                System.out.printf("%s ", index.displayChar);
            }
            System.out.printf("\n");
        }
        
    }

    private static Piece[][] initialState(){
        Piece [][] newBoard = new Piece[8][8];
            for(int x = 0; x < 8; x++){
                for(int y = 0; y < 8; y++){
                    newBoard[x][y] = new pawn();
                }
            }

        return newBoard;
    }


}