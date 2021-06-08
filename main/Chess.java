package main;
import java.util.Scanner;
import main.chessPieces.*;

public class Chess{

    public static void main(String [] args){

        Piece[][] chessBoard = initialState();
        Scanner input = new Scanner(System.in);
        
        int [] move;
        boolean gameCont = true;
        
        while(gameCont){
            boardDisplay(chessBoard);
            move = playerInput(input);
            if(chessBoard[move[0]][move[1]] == null){
                System.out.println("Invalid move");
                break;
            } else if(chessBoard[move[0]][move[1]].movement(move[3],move[2])){
                chessBoard[move[2]][move[3]] = chessBoard[move[0]][move[1]];
                chessBoard[move[0]][move[1]] = null;
            }
            

        }

        input.close();
        
    }

    private static int[] playerInput(Scanner input){

        int [] output = new int[4];
        int index = 0;

        while(index < 4){

            if(index < 2){
                System.out.println("Choose a piece. EX:A2");
            } else {
                System.out.println("Choose where to move. EX:B2");
            }
            
            String move = input.nextLine();
            if(move.length() == 2){
                int xChar = (int)move.charAt(0);
                int yChar = (int)move.charAt(1);
                //ASCii: 65~72 -> A~H & 49~55 -> 1~7
                if(xChar < 65 || xChar > 72 || yChar < 49 || yChar > 55){
                    System.out.println("Invalid Input");
                } else {
                    output[index++] = xChar - 64;
                    output[index++] = yChar - 48;
                }
            } else {
                System.out.println("Invalid Input");
            }
                      
        }

        return output;

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

        newBoard[0] = new Piece[]{new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};
        newBoard[1] = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn()};
        newBoard[6] = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn()};
        newBoard[7] = new Piece[]{new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};

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