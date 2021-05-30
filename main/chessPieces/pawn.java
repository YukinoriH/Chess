package main.chessPieces;

public class pawn extends Piece {

    boolean firstMove = true;

    public pawn(){
        super("PAWN",'P');
    }

    public void movement(){
        
    }

    public boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(endX > xPos + 2 || endY > yPos + 3){
            return false;
        }

        if(endY == yPos + 2 && endX == xPos && firstMove){
            firstMove = false;
        }

        return true;
    }
}
