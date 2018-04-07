package BOJ_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        arr = new int[N + 1];
        dp = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        if(N==1){
            System.out.println(arr[1]);
            return;
        } else if (N < 3) {
            System.out.println(arr[1] + arr[2]);
            return;
        }

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]));
        }

        long result = 0;
        for (int i = 1; i < N + 1; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
