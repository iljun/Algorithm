package BOJ_11057_2;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 24
 * Time: 오후 1:32
 */
public class Main {

    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        writer.write(solve(n));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n) {
        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i - 1][j] % MOD + dp[i][j - 1] % MOD) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        return String.valueOf(result);
    }
}
