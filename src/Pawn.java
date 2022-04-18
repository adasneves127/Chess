import javax.swing.*;

public class Pawn extends Piece {
    public Pawn(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 0;
        System.out.println("Pawn created!");

        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/Pawn.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/Pawn.png");
        }
    }
}