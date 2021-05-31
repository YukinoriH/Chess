package main.chessPieces;

public class Queen extends Piece{

    public Queen(){
        super("QUEEN", 'Q');
    }

    public boolean validPath(int endX, int endY){return false;};
}
