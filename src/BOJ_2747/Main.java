package BOJ_2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] fibonacci = new long[46];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        fibonacci[0] = 0;
        fibonacci[1] = fibonacci[2] = 1;

        for(int i=3; i<46; i++){
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        System.out.println(fibonacci[N]);
    }
}
