package main.chessPieces;
import java.lang.Math;

public abstract class Piece {

    public String pieceName;
    public char displayChar;
    public int xPos,yPos,player;

    public Piece(String pieceName, char displayChar){
        this.pieceName = pieceName;
        this.displayChar = displayChar;
    }

    public void updatePlayer(int player){
        this.player = player;
    }

    public void updatePos(int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    
    public boolean movement(int endX, int endY){
        if(validPath(endX, endY)){
            this.xPos = endX;
            this.yPos = endY;
            return true;
        }
        return false;
    }

    public abstract boolean validPath(int endX, int endY);

}
