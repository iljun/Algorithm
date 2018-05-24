package BOJ_11055;

import java.io.*;
import java.util.Arrays;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 24
 * Time: 오후 2:55
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(inputs[i]);

        writer.write(solve(n, arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int[] arr) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j] + arr[i] && arr[i] > arr[j]) {
                    dp[i] = dp[j] + arr[i];
                }
            }
        }

        int max = dp[0];
        for (int i = 1; i < n; i++)
            max = Math.max(max, dp[i]);

        return String.valueOf(max);
    }
}
