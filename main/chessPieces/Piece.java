package main.chessPieces;

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

    public abstract void movement();

    public abstract boolean validPath(int endX, int endY);

}
