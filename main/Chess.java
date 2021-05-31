package main;
import main.chessPieces.*;

public class Chess{

    public static void main(String [] args){
        boardDisplay(initialState());
    }

    public static void boardDisplay(Piece[][] boardState){
        //8x8
        System.out.println("   a b c d e f g h   ");
        System.out.println(" * * * * * * * * * * "); 
        int count = 8;  

        for(Piece[] row: boardState){
            System.out.printf("%d* ",count);
            for(Piece index: row){
                if(index == null){
                    System.out.printf("- ");
                } else{
                    System.out.printf("%s ", index.displayChar);
                }
                
            }
            System.out.printf("*%d", count);
            System.out.printf("\n");
            count--;
        }
        
        System.out.println(" * * * * * * * * * * ");  
        System.out.println("   a b c d e f g h   ");
        
    }

    private static Piece[][] initialState(){
        Piece [][] newBoard = new Piece[8][8];
        Piece [] backRow = {new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};
        Piece [] pawnRow = {new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn()};

        newBoard[0] = backRow;
        newBoard[1] = pawnRow;
        newBoard[6] = pawnRow;
        newBoard[7] = backRow;

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(newBoard[y][x] != null){
                    newBoard[y][x].updatePos(x, y);
                }
            }
        }

        return newBoard;
    }


}