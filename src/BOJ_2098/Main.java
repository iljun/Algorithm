package BOJ_2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        dp = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            result = Math.min(result, ts(i));
        }

        System.out.println(result);
    }

    public static long ts(int start) {
        long result = 0;
        int cnt = 1;
        visited[start] = true;
        int index = 0;
        int firstStart = start;

        while (cnt != N) {
            cnt++;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;

                if(dp[start][i]==0)
                    continue;

                if (min > dp[start][i]) {
                    min = dp[start][i];
                    index = i;
                }
            }

            visited[index] = true;
            result += dp[start][index];
            start = index;
        }

        return result + dp[start][firstStart];
    }
}
