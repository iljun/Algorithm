package BOJ_9095;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 6
 * Time: 오전 10:21
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());

        int n;
        while(t-->0){
            n = Integer.parseInt(reader.readLine());

            writer.write(String.valueOf(solve(n))+"\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    public int solve(int n){
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
