import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {
    int size = 20;
    private int[][] result = new int[size][size];

    public int[][] Cell() {
        return result;
    }

    public int[][] initCell() {
        Random rand = new Random();


        int i = rand.nextInt( 16);
        int j = rand.nextInt(17);
        i += 2;
        j += 2;
        for (int a = 0; a < size; a++) {
            for (int b = 0; b < size; b++) {
                result[a][b] = 0;
            }
        }
        result[i][j] = 1;
        result[i + 1][j + 1] = 1;
        result[i + 2][j + 1] = 1;
        result[i + 2][j] = 1;
        result[i + 2][j - 1] = 1;
        return result;
    }

    public boolean isLife(int n) {
        if (n == 1) return true;
        return false;
    }

    public int[][] nextLife(int[][] n) {
        int count = 0;
        int cnt = 0;
        int[][] keep = new int[100][2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count = checkCycle(i, j, n);
                //System.out.printf("count[%d][%d] = %d\n", i, j, count);
                if (count == 3) { //new born
                    if (!isLife(n[i][j])) {
                        n[i][j] = -1;
                    }
                    //System.out.printf("[%d][%d]\n", i, j);
                    if (checkCycle(i - 1, j - 1, n) == 3 && !isLife(n[i - 1][j - 1])) {
                        n[i - 1][j - 1] = -1;//born
                    }
                    if (checkCycle(i - 1, j, n) == 3 && !isLife(n[i - 1][j])) {
                        n[i - 1][j] = -1;//born
                    }
                    if (checkCycle(i - 1, j + 1, n) == 3 && !isLife(n[i - 1][j + 1])) {
                        n[i - 1][j + 1] = -1;//born
                    }
                    if (checkCycle(i, j - 1, n) == 3 && !isLife(n[i][j - 1])) {
                        n[i][j - 1] = -1;//born
                    }
                    if (checkCycle(i, j + 1, n) == 3 && !isLife(n[i][j + 1])) {
                        n[i][j + 1] = -1;//born
                    }
                    if (checkCycle(i + 1, j - 1, n) == 3 && !isLife(n[i + 1][j - 1])) {
                        n[i + 1][j - 1] = -1;//born
                    }
                    if (checkCycle(i + 1, j, n) == 3 && !isLife(n[i + 1][j])) {
                        n[i + 1][j] = -1;//born
                    }
                    if (checkCycle(i + 1, j + 1, n) == 3 && !isLife(n[i + 1][j + 1])) {
                        n[i + 1][j + 1] = -1;//born
                    }

                } else if (count == 1 || count > 3) { //die spot
                    keep[cnt][0] = i;
                    keep[cnt][1] = j;
                    cnt++;
                }

            }
        }
        for (int i = 0; i <= cnt; i++) {
            n[keep[i][0]][keep[i][1]] = 0;//set dead spot value
            //System.out.println("die " + keep[i][0] + " " + keep[i][1]);
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (n[i][j] == -1) {
//                    System.out.println("born " + i + " " + j);
                    n[i][j] = 1;//set new born spot value
                }
            }
        }
        return n;
    }

    public int checkCycle(int i, int j, int[][] n) {
        int count = 0;
        if (i > 0 && j > 0)
            if (n[i - 1][j - 1] == 1) {
                //System.out.println("[i-1][j-1]");
                count += 1;
            }
        if (i > 0)
            if (n[i - 1][j] == 1) {
                //System.out.println("[i-1][j]");
                count += 1;
            }
        if (i > 0 && j < size - 1)
            if (n[i - 1][j + 1] == 1) {
                //System.out.println("[i-1][j+1]");
                count += 1;
            }
        if (j > 0)
            if (n[i][j - 1] == 1) {
                //System.out.println("[i][j - 1]");
                count += 1;
            }
        if (j < size - 1)
            if (n[i][j + 1] == 1) {
                //System.out.println("[i][j + 1]");
                count += 1;
            }
        if (i < size - 1 && j > 0)
            if (n[i + 1][j - 1] == 1) {
                //System.out.println("[i + 1][j - 1]");
                count += 1;
            }
        if (i < size - 1)
            if (n[i + 1][j] == 1) {
                //System.out.println("[i + 1][j]");
                count += 1;
            }
        if (i < size - 1 && j < size - 1)
            if (n[i + 1][j + 1] == 1) {
                //System.out.println("[i+1][j+1]");
                count += 1;
            }
        return count;
    }
}
