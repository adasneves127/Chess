import java.awt.*;
import java.awt.Color;
import javax.swing.*;

public class BoardComponent extends JPanel{
    public int width, height, size, res;

    public Color white = new Color(242,225,195);
    public Color black = new Color(195,160,130);
    public JFrame window;

    public static Piece[][] board = new Piece[8][8];

    public static int scl;

    public BoardComponent(int width, int height, int size){
        scl = width / size;
        this.width = width;
        this.height = height;
        this.size = size;
        this.res = width / size;
        setupWindow();
        
        setupBoard();
        this.repaint();
        this.addMouseListener(new BoardMouseListener());
    }

    public void setupBoard(){
        // setup board
        // White Side
        board[0][0] = new Rook(0,0,true);
        board[1][0] = new Knight(1,0,true);
        board[2][0] = new Bishop(2,0,true);
        board[3][0] = new Queen(3,0,true);
        board[4][0] = new King(4,0,true);
        board[5][0] = new Bishop(5,0,true);
        board[6][0] = new Knight(6,0,true);
        board[7][0] = new Rook(7,0,true);
        for(int i = 0; i < size; i++){
            board[i][1] = new Pawn(1,i,true);
        }

        // Black Side
        for(int i = 0; i < size; i++){
            board[i][6] = new Pawn(i,6,false);
        }
        board[0][7] = new Rook(0,7,false);
        board[1][7] = new Knight(1,7,false);
        board[2][7] = new Bishop(2,7,false);
        board[3][7] = new Queen(3,7,false);
        board[4][7] = new King(4,7,false);
        board[5][7] = new Bishop(5,7,false);
        board[6][7] = new Knight(6,7,false);
        board[7][7] = new Rook(7,7,false);
    }

    public void setupWindow(){

        // Set up the panel, set it up, and add it.
        this.setSize(width, height);
        this.setVisible(true);
        this.invalidate();
        this.repaint();

        // Create a window, and set it up
        window = new JFrame("Chess");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(this);
        window.pack();
        window.setSize(width + 15, height + 40);
        window.setVisible(true);
    }

    public void paint(Graphics g){
        System.err.println("Painting Components!");
        super.paintComponents(g);
        g.setColor(Color.BLACK);
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(((i % 2) == 0) ^ ((j % 2) == 0)){
                    g.setColor(white);
                }
                else{
                    g.setColor(black);
                }
                g.fillRect(i * res, j * res, res, res);
            }
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != null){
                    board[i][j].draw(g, (int)((i * res) + 0.1 * res), (int)((j * res) + 0.2 * res));
                }
            }
        }
    }

    public void onPieceMove(){
        this.repaint();
    }

}
