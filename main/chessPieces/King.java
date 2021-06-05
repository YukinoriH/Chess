package main.chessPieces;

public class King extends Piece{

    public King(){
        super("KING", 'W');
    }
    
    public boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(Math.abs(xPos - endX) != 1 || Math.abs(yPos - endY) != 1){
            return false;
        }
        
        return false;
    }
}
