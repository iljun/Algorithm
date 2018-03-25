package BOJ_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] dp;
    static int[] xMove = {0, 0, 1, -1};
    static int[] yMove = {-1, 1, 0, 0,};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = reader.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int[] list : dp) {
            Arrays.fill(list, -1);
        }
//        DFS(0, 0);
        int result = dp(0, 0);

        System.out.println(result);
    }

//    public static void DFS(int x, int y) {//시간초과
//        if (x == N - 1 && y == M - 1) {
//            return;
//        }
//
//        for (int i = 0; i < 4; i++) {
//            int nextX = x + xMove[i];
//            int nextY = y + yMove[i];
//
//            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
//                if (arr[x][y] > arr[nextX][nextY]) {
//                    dp[nextX][nextY]++;
//                    DFS(nextX, nextY);
//                }
//            }
//        }
//    }

    public static int dp(int x, int y) {
        if (x == N - 1 && y == M - 1)
            return 1;

        if (dp[x][y] >= 0) {
            return dp[x][y];
        }

        if (dp[x][y] == -1)
            dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nextX = x + xMove[i];
            int nextY = y + yMove[i];

            if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M) {
                if (arr[x][y] > arr[nextX][nextY]) {
                    dp[x][y] += dp(nextX, nextY);
                }
            }
        }

        return dp[x][y];
    }
}
