import javax.swing.*;

//Bishop piece
public class Bishop extends Piece {
    public Bishop(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 3;
        System.out.println("Bishop created!");
        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/Bish.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/Bish.png");
        }
    }    
}
