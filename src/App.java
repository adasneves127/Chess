
public class App {

    public static int width, height, res, size;
    public static BoardComponent boardComp;

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
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
        boardComp = new BoardComponent(width, height, size);

       
        
    }
}
