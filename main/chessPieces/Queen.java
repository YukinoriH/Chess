package main.chessPieces;

public class Queen extends Piece{

    public Queen(){
        super("QUEEN", 'Q');
    }

    public boolean validPath(int endX, int endY){
        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(endX != xPos || endY != yPos){
            return false;
        } else if(Math.abs(xPos - endX) == Math.abs(yPos - endY)){
            return true;
        }

        return false;
    }
}
