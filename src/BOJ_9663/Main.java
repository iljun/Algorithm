package BOJ_9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] dp;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new int[N][N];

        DFS(0, 0);
        System.out.println(count);
    }

    public static void DFS(int x, int y) {
        if (x == N - 1 && y == N - 1) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (check(i, j)) {
                    dp[i][j] = 1;
                    DFS(i, j);
                    dp[i][j] = 0;
                }
            }
        }
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < N; i++) {//가로
            if (dp[x][i] == 1)
                return false;
        }

        for (int i = 0; i < N; i++) {//세로
            if (dp[i][y] == 1)
                return false;
        }

        int j;
        //x+1, y+1
        j = y;
        for (int i = x; i < N && j < N; i++, j++) {
            if (dp[i][j] == 1)
                return false;
        }

        //x-1, y-1
        j = y;
        for (int i = x; i >= 0 && j >= 0; i--, j--) {
            if (dp[i][j] == 1)
                return false;
        }

        //x+1, y-1
        j = y;
        for (int i = x; i < N && j >= 0; i++, j--) {
            if (dp[i][j] == 1)
                return false;
        }

        //x-1, y+1
        j = y;
        for (int i = x; i >= 0 && j < N; i--, j++) {
            if (dp[i][j] == 1)
                return false;
        }

        return true;
    }
}
