import javax.swing.*;

public class Knight extends Piece {
    public Knight(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 2;
        System.out.println("Knight created!");

        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/Knight.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/Knight.png");
        }
    }
}