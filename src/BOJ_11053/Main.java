package BOJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static List<Integer> list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        dp = new int[N];
        list = new ArrayList<>();
        String[] input = reader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(list.get(i)> list.get(j)){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }

        int max=dp[0];
        for(int i=1; i<N; i++){
            max = Math.max(dp[i],max);
        }

        System.out.println(max);
    }
}
