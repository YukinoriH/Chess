/*
Object class used for every chess piece
*/

package main.chessPieces;

public abstract class Piece {

    public String pieceName;
    public char displayChar;
    public int xPos,yPos,player;

    //displayChar is the char value used when the piece is shown in the terminal
    public Piece(String pieceName, char displayChar){
        this.pieceName = pieceName;
        this.displayChar = displayChar;
    }

    //Keeps track of if the piece belongs to player 1 or player 2
    public void updatePlayer(int player){
        this.player = player;
    }

    //Only called once the player makes a valid move
    public void updatePos(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    
    //Checks if the player's move is legal 
    public boolean movement(int endX, int endY){
        if(validPath(endX, endY)){
            updatePos(endX,endY);
            return true;
        }
        return false;
    }

    protected abstract boolean validPath(int endX, int endY);

}
