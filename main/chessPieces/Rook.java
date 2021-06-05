package main.chessPieces;

public class Rook extends Piece {
    
    public Rook(){
        super("ROOK", 'R');
    }

    public boolean validPath(int endX, int endY){

        if(endX > 7 || endX < 0 || endY > 7 || endY < 0){
            return false;
        }

        if(endX != xPos || endY != yPos){
            return false;
        }

        if(endX == xPos){
            return true;
        } else if(endY == yPos){
            return true;
        }
        
        return false;
    }
    
}
