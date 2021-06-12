package main;
import java.util.Scanner;

public class Chess{

    public static void main(String [] args){

        Board chessBoard = new Board();
        Scanner input = new Scanner(System.in);
        
        int [] move;
        boolean gameCont = true;
        
        while(gameCont){
            chessBoard.boardDisplay();
            move = playerInput(input);
            if(chessBoard.getPiece(move[0],move[1])== null){
                System.out.println("Invalid move");
            } else if(chessBoard.getPiece(move[0],move[1]).movement(move[3],move[2])){
                chessBoard.updatePiece(move[0],move[1],move[2],move[3]);
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
                int yChar = (int)move.charAt(0);
                int xChar = (int)move.charAt(1);
                //ASCii: 65~72 -> A~H & 49~55 -> 1~7
                if(xChar < 49 || xChar > 55 || yChar < 65 || yChar > 72){
                    System.out.println("Invalid Input");
                } else {
                    output[index++] = xChar - 49;   
                    output[index++] = yChar - 65;                                   
                }
            } else {
                System.out.println("Invalid Input");
            }
                      
        }

        return output;

    }


}