package BOJ_2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean ok = false;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        backtracking(N,1,"1");
    }

    public static void backtracking(int N, int depth, String sequence){
        if(ok)
            return ;

        if(!check(sequence)){
            return ;
        }

        if(depth==N){
            ok = true;
            System.out.println(sequence);
            return ;
        }

        for (int i = 1; i <= 3; i++) {
            sequence = sequence+String.valueOf(i);
            backtracking(N, depth + 1, sequence);
            sequence = sequence.substring(0, sequence.length() - 1);
        }

        return ;

    }

    public static boolean check(String sequence){
        int len = sequence.length();
        int start = len - 1;
        int end = len;
        for (int i = 1; i <= len/2; i++) {
            String first = sequence.substring(start-i, end-i);
            String second = sequence.substring(start,end);
            if (first.equals(second)) {
                return false;
            }
            --start;
        }
        return true;
    }
}
