/*
Tests all posible movement options for each chess piece.
When called, each function displays where the piece was positioned and where it was supposed to go to

TODO: 
    1) add test for every piece

*/

package main.unitTests;
import main.chessPieces.*;

public class piecesTests {
    
    public void testPawn(){
        Pawn test = new Pawn();
        test.updatePos(4, 4);
        for(int y = 0; y < 7; y++){
            for(int x = 0; x < 7; x++){
                System.out.printf("X:%d Y:%d ", x,y);
                System.out.printf("Boolean:%b /n",test.movement(x,y));
            }
        }
        
    }
    
}
