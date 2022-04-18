import javax.swing.*;

public class King extends Piece {
    public King(int x, int y, Boolean color) {
        super(x, y, color);
        super.type = 5;
        System.out.println("King created!");
        if(color){
            super.img = new ImageIcon("src/ChessPieces/White/King.png");
        }
        else{
            super.img = new ImageIcon("src/ChessPieces/Black/King.png");
        }
    } 
    
    
    public boolean isInCheck(){
        //check if the king is in check
        
        return false;
    }
}
