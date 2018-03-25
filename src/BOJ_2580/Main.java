package BOJ_2580;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        for (int i = 0; i < 9; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        DFS();

    }

    public static void DFS() {

        int x = -1;
        int y = -1;

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x != -1)
                break;
        }//0인곳 찾기

        if (x == -1 && y== -1) {
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
            return ;
        }//유효한 스도쿠는 출력

        for (int i = 1; i < 10; i++) {
            if (checkRow(x, i) && checkCol(y, i) && checkBox(x, y, i)) {
                arr[x][y] = i;
                DFS();
                arr[x][y] = 0;
            }
        }//빈곳에 값넣기

    }

    public static boolean checkRow(int row, int number) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == number)
                return false;
        }
        return true;
    }

    public static boolean checkCol(int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == number)
                return false;
        }
        return true;
    }

    public static boolean checkBox(int row, int col, int number) {
        int r = row / 3 * 3;
        int c = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[r + i][c + j] == number)
                    return false;
            }
        }

        return true;
    }

    public static boolean check() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (arr[i][j] == 0)
                    return false;
            }
        }
        return true;
    }
}
