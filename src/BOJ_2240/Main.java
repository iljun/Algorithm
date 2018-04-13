package BOJ_2240;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int t = Integer.parseInt(input[0]);
        int w = Integer.parseInt(input[1]);
        int[][] arr = new int[t + 1][3];

        for (int i = 1; i < t + 1; i++) {
            int index = Integer.parseInt(reader.readLine());
            arr[i][index] = 1;
        }

        writer.write(solve(arr, t, w));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int[][] arr, int t, int w) {

        int[][][] dp = new int[t + 1][w + 1][3];
        dp[1][0][1] = arr[1][1];
        dp[1][1][2] = arr[1][2];

        for (int i = 2; i < t + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
                if (j != 0) {
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + arr[i][1];
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + arr[i][2];
                } else {
                    dp[i][j][1] = dp[i - 1][j][1] + arr[i][1];
                    dp[i][j][2] = dp[i - 1][j][2] + arr[i][2];

                }
            }
        }

        int max = 0;
        for (int i = 0; i < w + 1; i++) {
            for (int j = 0; j < 3; j++) {
                max = Math.max(dp[t][i][j], max);
            }
        }
        return String.valueOf(max);
    }
}
