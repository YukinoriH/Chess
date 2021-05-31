package main.chessPieces;

public class Bishop extends Piece{

    public Bishop(){
        super("BISHOP", 'B');
    }

    public boolean validPath(int endX, int endY){return false;};
}
