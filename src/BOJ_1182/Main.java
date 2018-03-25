package BOJ_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static long S;
    static List<Integer> list;
    static int result=0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Long.parseLong(input[1]);

        list = new ArrayList<>();
        input = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(input[i]));
        }

        solve(0,0);

        if(S==0)
            result--;
        System.out.println(result);
    }

    static void solve(int current, int sum){
        if(current == N){
            if(sum==S){
                result++;
            }
            return;
        }

        solve(current+1,sum);
        solve(current+1,sum+list.get(current));
    }
}
