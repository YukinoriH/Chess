/*
The class used to create the chess board and keep track of the board state
The main functions are:
    1) Create new chess board
    2) Displays the current board state
    3) Checks if the the player's input is a valid movement option

The board is displayed as the follwing in the terminal:
      A B C D E F G H   
    * * * * * * * * * * 
  8 * - - - - - - - - * 8
  7 * - - - - - - - - * 7
  6 * - - - - - - - - * 6
  5 * - - - - - - - - * 5
  4 * - - - - - - - - * 4
  3 * - - - - - - - - * 3
  2 * - - - - - - - - * 2
  1 * - - - - - - - - * 1
    * * * * * * * * * * 
      A B C D E F G H
Each '-' is a null space and a possible location for a chess piece
Chess pieces are displayed as single characters matching the first letter of their names.
The character for the King piece is W, as 'K' is for the knight piece.

TODO: 
    1) Have error checks and returns proper value for invalid inputs
    2) Finish checkPath
    3) Create response to capture pieces
*/

package main;
import main.chessPieces.*;

public class Board {

    Piece [][] chessBoard = new Piece[8][8];


    public Board(){

        this.chessBoard[0] = new Piece[]{new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};
        this.chessBoard[1] = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn()};
        this.chessBoard[6] = new Piece[]{new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn(), new Pawn()};
        this.chessBoard[7] = new Piece[]{new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};

        for(int y = 0; y < 8; y++){
            for(int x = 0; x < 8; x++){
                if(this.chessBoard[y][x] != null){
                    this.chessBoard[y][x].updatePos(x, y);
                    if(y == 1 || y == 0){
                        this.chessBoard[y][x].updatePlayer(2);
                    } else if(y == 6 || y == 7) {
                        this.chessBoard[y][x].updatePlayer(1);
                    }
                    
                }
            }
        }

    }

    public void boardDisplay(){
        //8x8
        System.out.println("   A B C D E F G H   ");
        System.out.println(" * * * * * * * * * * "); 
        int count = 8;  

        for(Piece[] row: this.chessBoard){
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
        System.out.println("   A B C D E F G H   ");
        
    }

    public Piece getPiece(int y, int x){
        return this.chessBoard[y][x];
    }

    public void updatePiece(int oldX, int oldY, int newX, int newY){
        this.chessBoard[oldY][oldX].updatePos(newX, newY);
        this.chessBoard[newY][newX] = this.chessBoard[oldY][oldX];
        this.chessBoard[oldY][oldX] = null;
    }

    //Method used to check for other chess pieces between the start point and end point
    //3 types of movement: type 1 = horizontal, 2 = vertical, 3 = diagnal
    //Each movement type has different loops in the same direction, but contains different start and end points
    public Piece checkPath(int fromX, int fromY, int toX, int toY, int type){

        //If there is a chess piece located at the end point, 
        //then it should be the only piece in the path for the movement to be considered valid
        //If there is no piece, then foundPiece is null.
        Piece foundPiece = this.chessBoard[toX][toY];

        switch(type){
            case(1):
                if(fromY > toY){
                    //left
                    loopBoardList(fromX, toY, toX, fromY, foundPiece);
                } else if (fromY < toY){
                    //right
                    loopBoardList(fromX, fromY, toX, toY, foundPiece);
                } else {
                    //invalid
                }


            case(2):
                if(fromX > toX){
                    //down
                    loopBoardList(fromX, fromY, toX, toY, foundPiece);
                } else if (fromX < toX){
                    //up
                    loopBoardList(toX, fromY, fromX, toY, foundPiece);
                } else {
                    //invalid
                }
            case(3):
                if(fromY > toY && fromX > toX){
                    //bottom-left
                    
                } else if (fromY > toY && fromX < toX){
                    //top-left
                    
                } else if(fromY < toY && fromX > toX){
                    //bottom-right

                } else if(fromY < toY && fromX < toX){
                    //top-right

                } else{
                    //invalid

                }
        }
        return null;
    } 

    private Piece loopBoardList(int startX, int startY, int endX, int endY, Piece foundPiece){

        for(int y = startY; y <= endY; y++){
            for(int x = startX; x <= endX; x++){
                if(this.chessBoard[y][x] != null){
                    if(foundPiece == null){
                        foundPiece = this.chessBoard[y][x];
                    } else {
                        //invalid
                    }
                }
            }

        }

        return foundPiece;
    }
    
}
