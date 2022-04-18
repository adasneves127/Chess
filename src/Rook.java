import javax.swing.*;
public class Rook extends Piece {
    public Rook(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 1;
        System.out.println("Rook created!");

        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/Rook.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/Rook.png");
        }
    }
}
