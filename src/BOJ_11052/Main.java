package BOJ_11052;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 4. 28
 * Time: 오후 3:03
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n + 1];
        String[] input = reader.readLine().split(" ");
        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        writer.write(String.valueOf(solve(n, arr)));

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n, int[] arr) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                if (dp[i] < dp[i - j] + arr[j])
                    dp[i] = dp[i - j] + arr[j];
            }
        }
        return dp[n];
    }
}
