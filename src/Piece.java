import java.awt.Graphics;
import javax.swing.*;

public class Piece {
    public int x, y;
    public boolean isWhite;
    public ImageIcon img;
    public int type; 
    /* 
        0 = Pawn
        1 = Rook
        2 = Knight
        3 = Bishop
        4 = Queen
        5 = King
    */

    public Piece(int x, int y, Boolean color) {
        this.x = x;
        this.y = y;
        this.isWhite = color;
        System.out.println("Piece created!");
    }

    public void draw(Graphics g, int x, int y) {
        g.drawImage(img.getImage(), x, y, null);
    }

    public static void move(Piece[][] board, int X1, int Y1, int X2, int Y2) {
        board[X2][Y2] = board[X1][Y1];
        board[X1][Y1] = null;
        board[X2][Y2].x = X2;
        board[X2][Y2].y = Y2;
    }

    public static boolean validateMove(Piece[][] board, int X1, int Y1, int X2, int Y2){

        return false;
    }

    public static int[][] getAllMoves(int x, int y, int pieceType, Piece[][] board){

        switch(pieceType){
            case 1 -> {}
        }

        return null;
    }
}

