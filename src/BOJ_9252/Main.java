package BOJ_9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    static String N;
    static String M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = reader.readLine();
        M = reader.readLine();

        N = "0" + N;
        M = "0" + M;

        dp = new int[N.length()][M.length()];

        for (int i = 0; i < N.length(); i++) {
            for (int j = 0; j < M.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (N.charAt(i) == M.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        List<String> stack = new Stack<>();

        int i = N.length() - 1;
        int j = N.length() - 1;

        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j]-1 == dp[i - 1][j - 1]) {
                stack.add(String.valueOf(N.charAt(i)));
                i--;
                j--;
            }
        }

        StringBuilder builder = new StringBuilder();

        while(!stack.isEmpty()){
            builder.append(stack.remove(stack.size()-1));
        }

        System.out.println(dp[N.length()-1][M.length()-1]);
        System.out.println(builder.toString());
    }
}
