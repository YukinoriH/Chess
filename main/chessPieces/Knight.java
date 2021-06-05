package main.chessPieces;

public class Knight extends Piece{

    public Knight(){
        super("KNIGHT", 'K');
    }

    public boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(xPos == endX || yPos == endY){
            return false;
        }

        if(Math.abs(xPos - endX) > 2 || Math.abs(yPos - endY) > 2){
            return false;
        }

        if(Math.abs(xPos - endX) == 2 && Math.abs(yPos - endY) == 1){
            return true;
        }

        if(Math.abs(yPos - endY) == 2 && Math.abs(xPos - endX) == 1){
            return true;
        }

        return false;
    }
    
}
