package BOJ_14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] T;
    static int[] P;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        T = new int[N];
        P = new int[N];
        arr = new int[N][N];

        String[] input;
        for(int i=0; i<N; i++){
            input = reader.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        int result=0;
        for(int i=0; i<N; i++){
            result = Math.max(result,DFS(i));
        }

        System.out.println(result);
    }

    public static int DFS(int x){
        if(x>N-1 || x+T[x] > N)
            return 0;

        int result=0;
        for(int i = x+T[x]; i<N+1; i++){
            result = Math.max(result,DFS(i));
        }

        return result + P[x];
    }

}
