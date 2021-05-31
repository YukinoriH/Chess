package main.chessPieces;

public class King extends Piece{

    public King(){
        super("KING", 'W');
    }
    
    public boolean validPath(int endX, int endY){return false;};
}
