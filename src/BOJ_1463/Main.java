package BOJ_1463;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 23
 * Time: 오후 6:38
 */
public class Main {
    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        writer.write(solve(n));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n){
        int[] dp = new int[n+1];
        dp[1]=0;

        for(int i=2; i<n+1; i++){
            int min = dp[i-1];
            if(i%3==0){
                min = Math.min(min,dp[i/3]);
            }else if(i%2==0){
                min = Math.min(min,dp[i/2]);
            }
            dp[i] = min+1;
        }

        return String.valueOf(dp[n]);
    }
}
