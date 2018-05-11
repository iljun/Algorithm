package BOJ_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static List<Integer> list;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        dp = new long[N+1];
        list = new ArrayList<>();

        if(N==M) {
            System.out.println(1);
            return;
        }

        for(int i=1; i<=N; i++){
            list.add(i);
        }

        for (int i = 0; i < M; i++) {
            list.set(Integer.parseInt(reader.readLine())-1,0);
        }

        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        for(int i=3; i<=N;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        long result = 1;
        int pre=0;
        int next=0;
        for(int i=0; i<N; i++){
            if(list.get(i)==0){
                next = i+1;
                result *=dp[next-pre-1];
                pre = i+1;
            }

        }

        if(pre!=list.size())
            result*=dp[list.size()-next];

        System.out.println(result);
    }
}
