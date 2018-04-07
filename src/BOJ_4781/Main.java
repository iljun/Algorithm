package BOJ_4781;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static int[] candyCalorie;
    static int[] candyCost;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;
        while (true) {

            input = reader.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = (int) ((Double.parseDouble(input[1]) * 100) + 0.5);

            dp = new int[M + 1];
            candyCalorie = new int[N];
            candyCost = new int[N];

            if (N == 0 && M == 0) {
                break;
            }

            for (int i = 0; i < N; i++) {
                input = reader.readLine().split(" ");
                int calorie = Integer.parseInt(input[0]);
                int cost = (int) ((Double.parseDouble(input[1]) * 100) + 0.5);

                candyCalorie[i] = calorie;
                candyCost[i] = cost;
            }

            dp[0] = 0;
            for (int i = 0; i < N; i++) {
                for (int j = candyCost[i]; j < M + 1; j++) {
                    dp[j] = Math.max(dp[j], dp[j - candyCost[i]] + candyCalorie[i]);
                }
            }

            int max = 0;
            for (int i = 0; i < M + 1; i++) {
                max = Math.max(max, dp[i]);
            }

            writer.write(String.valueOf(max) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

}
