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

    public Piece getPiece(int x, int y){
        return this.chessBoard[y][x];
    }

    public void updatePiece(int oldX, int oldY, int newX, int newY){
        this.chessBoard[oldX][oldY].updatePos(newX, newY);
        this.chessBoard[newX][newY] = this.chessBoard[oldX][oldY];
        this.chessBoard[oldX][oldY] = null;
    }
    
}
