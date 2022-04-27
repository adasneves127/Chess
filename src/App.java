public class App {

    //Create our width, height, res, and size variables.
    public static int width, height, res, size;

    //This is the board.
    public static BoardComponent boardComp;

    public static void main(String[] args) throws Exception {
        
        //If we supplied any arguments, try to parse them. If we fail, default to the default values.
        try{
            width = Integer.parseInt(args[0]);
            height = width;
            size = 8;
            res = width / size;
        }catch(Exception e){
            width = 800;
            height = width;
            size = 8;
            res = width / size;
        }
        //Start our game
        boardComp = new BoardComponent(width, height, size);
    }
}
