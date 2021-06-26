package main.chessPieces;

public class Bishop extends Piece{

    public Bishop(){
        super("BISHOP", 'B');
    }

    public boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(xPos == endX || yPos == endY){
            return false;
        }
        // Diagnal movement requires the same unit of X and Y movements 
        // (ex: 2x & 2y to go top right, -2x & 2y to go top left)
        if(Math.abs(xPos - endX) == Math.abs(yPos - endY)){
            return true;
        }
        return false;
    }
}
