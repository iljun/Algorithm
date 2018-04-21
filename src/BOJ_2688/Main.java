package BOJ_2688;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        int n;
        while(t-->0) {
            n = Integer.parseInt(reader.readLine());
            if (n == 0)
                writer.write(String.valueOf("1"));
            else if(n==1){
                writer.write(String.valueOf("10"));
            } else {
                long[][] dp = new long[n + 1][10];
                for (int i = 0; i < 10; i++) {
                    dp[1][i] = 1;
                    dp[2][i] = i + 1;
                }

                if (dp[n][0] == 0) {
                    for (int i = 3; i <= n; i++) {
                        dp[i][0] = 1;
                        for (int j = 1; j < 10; j++) {
                            dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                        }
                    }
                }

                long cnt = 0;
                for (int i = 0; i < 10; i++)
                    cnt += dp[n][i];

                writer.write(String.valueOf(cnt) + "\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }

}
