package BOJ_2616;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] input) throws IOException {
        new Main().input();
    }

    private void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n + 1];

        String[] input = reader.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        int m = Integer.parseInt(reader.readLine());
        writer.write(solve(arr, m,n));

        reader.close();
        writer.flush();
        writer.close();
    }

    private String solve(int[] arr, int m, int n) {
        long[][] dp = new long[4][n+1];
        long[] tmp = new long[n+1];
        for (int i = 1; i < n + 1; i++) {
            tmp[i] = tmp[i-1] + arr[i];
        }

        for (int i = 1; i < 4; i++) {
            for (int j = i * m; j < n+1; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], (tmp[j] - tmp[j - m]) + dp[i - 1][j - m]);
            }
        }

        return String.valueOf(dp[3][dp[0].length - 1]);
    }
}
