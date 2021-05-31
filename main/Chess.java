package main;
import java.util.Scanner;
import main.chessPieces.*;

public class Chess{

    public static void main(String [] args){

        Piece[][] chessBoard = initialState();
        Scanner input = new Scanner(System.in);
        int [] move;
        
        while(true){
            boardDisplay(chessBoard);
            move = playerInput(input);
            break;
        }

        input.close();
        
    }

    private static int[] playerInput(Scanner input){

        System.out.println("Enter your move. EX: A2 to A3");
        String move = input.nextLine();
        int [] invalid = new int[]{-1};

        if(move.length() < 0 || move.length() > 8){
            return invalid;
        } 
        //ASCii 65~72 -> A~H & 97~104 -> a~h
        char temp1 = move.charAt(0);
        int temp = (int)temp1;

        if(temp < 65 || temp > 72){
            return invalid;
        }

        temp1 = move.charAt(1);
        temp = (int)temp1;

        if(temp < 1 || temp > 8){

        }

        return invalid;
        

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