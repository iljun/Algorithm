package BOJ_1019;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{ //시간초과
        new Main().input();
    }

    public void input() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(reader.readLine());

        int[] dp = new int[10];

        for(int i=1; i<n+1; i++){
            if(9<i){
                int t = i;
                while(t/10!=0){
                    dp[t%10]++;
                    t= t/10;
                }
            }else{
                dp[i]++;
            }
        }

        System.out.println(Arrays.toString(dp));
    }
}
