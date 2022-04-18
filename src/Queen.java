import javax.swing.*;

public class Queen extends Piece {
    public Queen(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 4;
        System.out.println("Queen created!");
        
        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/Queen.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/Queen.png");
        }
    }
}
