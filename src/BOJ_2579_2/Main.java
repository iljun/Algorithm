package BOJ_2579_2;

import java.io.*;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 23
 * Time: 오후 7:02
 */
public class Main {

    public static void main(String[] args) throws IOException{
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];

        String input;
        for(int i=1; i<n+1; i++){
            input = reader.readLine();
            arr[i] = Integer.parseInt(input);
        }

        writer.write(solve(n,arr));

        reader.close();
        writer.flush();
        writer.close();
    }

    public String solve(int n, int[] arr){
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        dp[1] = Math.max(dp[0]+arr[1],arr[1]);
        dp[2] = Math.max(dp[0],dp[1])+arr[2];

        for(int i=3; i<n+1; i++){
            dp[i] = Math.max(dp[i-2],dp[i-3]+arr[i-1])+arr[i];
        }

        return String.valueOf(dp[n]);
    }
}
