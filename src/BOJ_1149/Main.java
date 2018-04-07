package BOJ_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new int[3][N];
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[2][0] = arr[2][0];
        for (int i = 1; i < N; i++) {
            dp[0][i] = arr[0][i] + Math.min(arr[1][i-1], arr[2][i-1]);//R
            dp[1][i] = arr[1][i] + Math.min(arr[0][i-1], arr[2][i-1]);//G
            dp[2][i] = arr[2][i] + Math.min(arr[0][i-1], arr[1][i-1]);//B
        }

        System.out.println(Arrays.deepToString(dp));
    }
}
