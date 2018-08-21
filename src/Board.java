import java.util.List;
import java.util.Random;

public class Board {
    private static int size = 20;
    private int[][] Broad = new int[10][10];
    static Cell c = new Cell();
    static int[][] fristLife = c.initCell();
    static Random rand = new Random();
    public static void createLife(){
        for(int a = 0 ; a < size ;  a++ ){
            for(int b = 0 ; b < size ; b++){
                if(fristLife[a][b] == 1){
                    System.out.printf("(%d,%d)",a,b);
                }
                if(fristLife[a][b] == 0)
                    System.out.print("(_,_)");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public static void main(String[] arg) {
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();
        fristLife = c.nextLife(fristLife);
        createLife();


    }

}
