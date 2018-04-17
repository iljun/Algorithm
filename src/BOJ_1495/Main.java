package BOJ_1495;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().input();
    }

    public void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        int s;
        int m;

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        s = Integer.parseInt(input[1]);
        m = Integer.parseInt(input[2]);

        int[] arr = new int[n+1];

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i+1] = Integer.parseInt(input[i]);
        }

        writer.write(solve(n, s, m, arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int s, int m, int[] arr) {
        int[][] dp = new int[n+1][m+1];

        dp[0][s] = 1;


        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] == 1) {
                    if (j + arr[i] <= m) dp[i][j + arr[i]] = 1;
                    if (j - arr[i] >= 0) dp[i][j - arr[i]] = 1;
                }
            }
        }

        int max = -1;

        for(int i=0; i<m+1; i++){
            if(dp[n][i]==1)
                max = Math.max(i,max);
        }

        return String.valueOf(max);
    }
}
