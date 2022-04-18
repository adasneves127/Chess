import java.awt.event.*;


public class BoardMouseListener implements MouseListener {
    int clickedX, clickedY, relX, relY;
    public void mousePressed(MouseEvent e) {
        clickedX = e.getX() / BoardComponent.scl;
        clickedY = e.getY() / BoardComponent.scl;
     }
 
     public void mouseReleased(MouseEvent e) {
        relX = e.getX() / BoardComponent.scl;
        relY = e.getY() / BoardComponent.scl;

        if(BoardComponent.board[clickedX][clickedY] == null)
            return;

        if(Piece.validateMove(BoardComponent.board, clickedX, clickedY, relX, relY)){
            Piece.move(BoardComponent.board, clickedX, clickedY, relX, relY);
            App.boardComp.onPieceMove();
        }
        
     }
 

     //Unused Methods
     public void mouseEntered(MouseEvent e) {
        
     }
 
     public void mouseExited(MouseEvent e) {
        
     }
 
     public void mouseClicked(MouseEvent e) {
        
     }
    
}
