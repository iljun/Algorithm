package BOJ_11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int K;
    static int N;
    static int[] arr;
    static int[][] dp;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(reader.readLine());

        while (K-- > 0) {
            N = Integer.parseInt(reader.readLine());
            arr = new int[N+1];
            dp = new int[N+1][N+1];
            sum = new int[N+1];

            String[] input = reader.readLine().split(" ");
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(input[i-1]);
                if (i == 0)
                    sum[i] = arr[i];
                else
                    sum[i] = arr[i] + sum[i-1];
            }

            for (int[] t : dp) {
                Arrays.fill(t, -1);
            }

//            for (int i = 1; i < N+1; i++) {
//                for (int j = 1; j < N+1; j++) {
//                    if (j == i) {
//                        dp[i][j] = 0;
//                        continue;
//                    }
//
//                    if (i + 1 == j) {
//                        dp[i][j] = arr[i] + arr[j];
//                        continue;
//                    }
//
//                    dp[i][j] = Integer.MAX_VALUE;
//
//                    for (int k = i; k < j; k++) {
//                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + (sum[j] - sum[i-1]));
//                    }
//                }
//            } //dp
//            System.out.println(Arrays.deepToString(dp));
            int result = dp(1, N);
            System.out.println(result);
        }
    }

    public static int dp(int start, int end) {
        if (start >= end)
            return 0;

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        if (end - start == 1)
            return arr[start] + arr[end];

        dp[start][end] = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            int tmp = dp(start, i) + dp(i + 1, end) + sum[end] - sum[start - 1];
            dp[start][end] = Math.min(dp[start][end], tmp);
        }

        return dp[start][end];
    }
}
