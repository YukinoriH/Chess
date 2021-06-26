/*
The main class used to run the program.

TODO: 
    1) Add win/tie condition
    2) Checks if the selected piece is owned by the player
    3) Add error checks for invalid inputs
*/

package main;
import java.util.Scanner;

public class Chess{

    public static void main(String [] args){

        Board chessBoard = new Board();
        Scanner input = new Scanner(System.in);
        
        int [] move;
        boolean gameCont = true;
        int playerTurn = 1;
        
        while(gameCont){
            chessBoard.boardDisplay();
            move = playerInput(input);
            if(chessBoard.getPiece(move[0],move[1])== null){
                System.out.println("Invalid move");
            } else if(chessBoard.getPiece(move[0],move[1]).movement(move[3],move[2])){
                chessBoard.updatePiece(move[1],move[0],move[3],move[2]);

                if(playerTurn == 2){
                    playerTurn--;
                } else {
                    playerTurn++;
                }
            }           

        }

        input.close();
        
    }

    private static int[] playerInput(Scanner input){

        int [] output = new int[4];
        int index = 0;

        while(index < 4){

            if(index < 2){
                System.out.println("Choose a piece");
            } else {
                System.out.println("Choose where to move");
            }
             
            String move = input.nextLine();
            if(move.length() == 2){               
                int xChar = (int)move.charAt(0);
                int yChar = (int)move.charAt(1);
                
                //ASCii values: 65~72 -> A~H & 49~57 -> 1~8               
                if(yChar < 49 || yChar > 57 ||  xChar < 65 ||  xChar > 72){
                    System.out.println("Invalid Input");
                } else {
                    //yChar needs to be returned as a value from 1 - 8 to match the board
                    //However, the Board is reversed on the x-axis. i.e. A1 would be at int board[0][7]
                    //yChar - 49(gets proper int value) - 7(to match the correct spot in board[][]) 
                    output[index++] = Math.abs(yChar - 49 - 7);
                    output[index++] = xChar - 65;                                   
                }
            } else {
                System.out.println("Invalid Input");
            }
                      
        }

        return output;

    }


}