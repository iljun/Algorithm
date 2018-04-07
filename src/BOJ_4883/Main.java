package BOJ_4883;

import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int cnt = 1;
        while(!input[0].equals("0")){
            N = Integer.parseInt(input[0]);

            long[][] arr= new long[N][3];
            long[][] dp = new long[N][3];

            for(int i=0; i<N; i++){
                input = reader.readLine().split(" ");
                arr[i][0] = Integer.parseInt(input[0]);
                arr[i][1] = Integer.parseInt(input[1]);
                arr[i][2] = Integer.parseInt(input[2]);
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];
            dp[0][2] = arr[0][2] + arr[0][1];

            dp[1][0] = dp[0][1] + arr[1][0];
            dp[1][1] = Math.min(dp[0][1],Math.min(dp[0][2],dp[1][0])) + arr[1][1];
            dp[1][2] = Math.min(dp[0][1],Math.min(dp[0][2],dp[1][1])) + arr[1][2];

            for(int i=2; i<N; i++){
                dp[i][0] = arr[i][0] + Math.min(dp[i-1][0],dp[i-1][1]);
                dp[i][1] = arr[i][1] + Math.min(dp[i-1][0],Math.min(dp[i-1][1],Math.min(dp[i-1][2],dp[i][0])));
                dp[i][2] = arr[i][2] + Math.min(dp[i-1][1],Math.min(dp[i-1][2],dp[i][1]));
            }
            long result = dp[N-1][1];

            System.out.println(cnt + ". " + result);
            cnt++;
            input = reader.readLine().split(" ");
        }

    }
}
