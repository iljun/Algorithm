package BOJ_3085;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    static int[] xMove = {-1, 1, 0, 0};
    static int[] yMove = {0, 0, -1, 1};

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[][] arr = new String[n][n];

        String[] input;
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = input[j];
            }
        }

        int result = calculate(arr, 0, 0, 0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, swap(n, arr, i, j));
            }
        }

        writer.write(String.valueOf(result));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int swap(int n, String[][] arr, int x, int y) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int swapX = x + xMove[i];
            int swapY = y + yMove[i];

            if (swapX < 0 || swapX > n - 1 || swapY < 0 || swapY > n - 1)
                continue;

            if (arr[x][y].equals(arr[swapX][swapY]))
                continue;

            String tmp = arr[x][y];
            arr[x][y] = arr[swapX][swapY];
            arr[swapX][swapY] = tmp;

            //계산
            result = Math.max(result, calculate(arr, x, y, swapX, swapY));

            tmp = arr[x][y];
            arr[x][y] = arr[swapX][swapY];
            arr[swapX][swapY] = tmp;
        }

        return result;
    }

    public int calculate(String[][] arr, int x, int y, int swapX, int swapY) {
        int result = 0;
        int size = arr[0].length;
        // x,y
        int horizontal = 0;
        int vertical = 0;

        for (int i = 0; i < size; i++) {
            if (arr[x][y].equals(arr[i][y])) {
                vertical++;
            } else {
                result = Math.max(result, vertical);
                vertical = 0;
            }

            if (arr[x][y].equals(arr[x][i])) {
                horizontal++;
            } else {
                result = Math.max(result, horizontal);
                horizontal = 0;
            }
        }
        if (vertical != 0) {
            result = Math.max(result, vertical);
        }

        if (horizontal != 0) {
            result = Math.max(result, horizontal);
        }
        //swapX,swapY
        horizontal = 0;
        vertical = 0;
        for (int i = 0; i < size; i++) {
            if (arr[swapX][swapY].equals(arr[i][swapY])) {
                vertical++;
            } else {
                result = Math.max(result, vertical);
                vertical = 0;
            }

            if (arr[swapX][swapY].equals(arr[swapX][i])) {
                horizontal++;
            } else {
                result = Math.max(result, horizontal);
                horizontal = 0;
            }
        }
        if (vertical != 0) {
            result = Math.max(result, vertical);
        }

        if (horizontal != 0) {
            result = Math.max(result, horizontal);
        }
        return result;
    }
}
