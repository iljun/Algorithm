package BOJ_2631;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        list = new int[N];

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            list[i] = Integer.parseInt(input);
        }

        int result = LIS(list);
        System.out.println(list.length - result);
    }

    public static int LIS(int[] list) {
        int[] dp = new int[list.length];

        for (int i = 0; i < list.length; i++) {
            if (dp[i] == 0)
                dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list[i] > list[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
