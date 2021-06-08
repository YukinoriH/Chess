package main.chessPieces;

public class Pawn extends Piece {

    boolean firstMove = true;

    public Pawn(){
        super("PAWN",'P');
    }

    protected boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(endX > xPos + 1 || endY > yPos + 2){
            return false;
        }

        if(endY == yPos + 2 && endX == xPos && firstMove){
            firstMove = false;
        }

        return true;
    }
}
