import java.awt.Graphics;
import java.util.ArrayList;

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
        System.err.println("Piece.move() called!");

        board[X2][Y2] = board[X1][Y1];
        board[X1][Y1] = null;
        board[X2][Y2].x = X2;
        board[X2][Y2].y = Y2;

        if(board[X2][Y2].type == 5) {
            if(board[X2][Y2].isWhite) {
                BoardComponent.whiteKing = (King)board[X2][Y2];
            } else {
                BoardComponent.blackKing = (King)board[X2][Y2];
            }
        }
    }

    public static boolean validateMove(Piece[][] board, int X1, int Y1, int X2, int Y2){
        System.err.println("Piece.validateMove() called!");
        System.err.println(X1 + " " + Y1 + " " + X2 + " " + Y2);
        if(board[X1][Y1] == null){
            return false;
        }
        ArrayList<int[]> moves = Piece.getAllMoves(X1, Y1, board[X1][Y1].type, board);
        for(int[] move : moves){
            System.err.println(move[0] + " " + move[1]);
            if(move[0] == X2 && move[1] == Y2){
                return true;
            }
        }

        return false;
    }

    public static ArrayList<int[]> getAllMoves(int x, int y, int pieceType, Piece[][] board){
        System.err.println("Piece.getAllMoves() called!");
        
        System.err.println(x + " " + y + " " + pieceType);
        ArrayList<int[]> moves = new ArrayList<int[]>();
        switch(pieceType){
            //Pawn
            case 0 -> {
                if(board[x][y].isWhite){
                    if(y == 1){
                        moves.add(new int[]{x, y + 2});
                    }
                    moves.add(new int[]{x, y + 1});
                    moves.add(new int[]{x - 1, y + 1});
                    moves.add(new int[]{x + 1, y + 1});
                }
                else{
                    if(y == 6){
                        moves.add(new int[]{x, y - 2});
                    }
                    moves.add(new int[]{x, y - 1});
                    moves.add(new int[]{x - 1, y - 1});
                    moves.add(new int[]{x + 1, y - 1});
                }
            }
            //Rook
            case 1 -> {
                for(int i = 1; i < 8; i++){
                    if(x + i < 8){
                        if(board[x + i][y] == null){
                            moves.add(new int[]{x + i, y});
                        }
                        else if(board[x + i][y].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x + i, y});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(x - i >= 0){
                        if(board[x - i][y] == null){
                            moves.add(new int[]{x - i, y});
                        }
                        else if(board[x - i][y].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x - i, y});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(y + i < 8){
                        if(board[x][y + i] == null){
                            moves.add(new int[]{x, y + i});
                        }
                        else if(board[x][y + i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x, y + i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(y - i >= 0){
                        if(board[x][y - i] == null){
                            moves.add(new int[]{x, y - i});
                        }
                        else if(board[x][y - i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x, y - i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            //Knight
            case 2 -> {
                moves.add(new int[]{x + 1, y + 2});
                moves.add(new int[]{x + 2, y + 1});
                moves.add(new int[]{x + 2, y - 1});
                moves.add(new int[]{x + 1, y - 2});
                moves.add(new int[]{x - 1, y - 2});
                moves.add(new int[]{x - 2, y - 1});
                moves.add(new int[]{x - 2, y + 1});
                moves.add(new int[]{x - 1, y + 2});
            }
            //Bishop
            case 3 -> {
                for(int i = 1; i < 8; i++){
                    if(x + i < 8 && y + i < 8){
                        if(board[x + i][y + i] == null){
                            moves.add(new int[]{x + i, y + i});
                        }
                        else if(board[x + i][y + i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x + i, y + i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(x + i < 8 && y - i >= 0){
                        if(board[x + i][y - i] == null){
                            moves.add(new int[]{x + i, y - i});
                        }
                        else if(board[x + i][y - i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x + i, y - i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(x - i >= 0 && y + i < 8){
                        if(board[x - i][y + i] == null){
                            moves.add(new int[]{x - i, y + i});
                        }
                        else if(board[x - i][y + i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x - i, y + i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
                for(int i = 1; i < 8; i++){
                    if(x - i >= 0 && y - i >= 0){
                        if(board[x - i][y - i] == null){
                            moves.add(new int[]{x - i, y - i});
                        }
                        else if(board[x-i][y-i].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x - i, y - i});
                            break;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            //Queen
            //Queen moves like a bishop and a rook
            case 4 -> {
                ArrayList<int[]> bishopMoves = getAllMoves(x, y, 1, board);
                ArrayList<int[]> RookMoves = getAllMoves(x, y, 3, board);
                moves.addAll(bishopMoves);
                moves.addAll(RookMoves);
            }
            //King
            case 5 -> {
                for(int i = -1; i < 1; i++){
                    for(int j = -1; j < 1; j++){
                        if(x + i >= 8 || x + i < 0 || y + j >= 8 || y + j < 0){
                            continue;
                        }
                        if(board[x + i][y + j] == null){
                            moves.add(new int[]{x + i, y + j});
                        }
                        else if(board[x + i][y + j].isWhite != board[x][y].isWhite){
                            moves.add(new int[]{x + i, y + j});
                        }
                    }
                }
            }
        }
        return moves;
    }
}

