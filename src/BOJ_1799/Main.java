package BOJ_1799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int result=0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        DFS(0,0);
        System.out.println(result);
    }

    public static void DFS(int x, int y){
        if(arr[x][y]==0)
            return;

        if(x==N-1 && y==N-1) {
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==0)
                    continue;
                if(check(i,j)){
                    arr[i][j] = 2;
                    DFS(i,j);
                    arr[i][j] = 1;
                }
            }
        }
        return;
    }

    public static boolean check(int x, int y){
        int i = x;
        int j = y;

        //x+1 y+1
        for(; i<N && j<N; i++){
            if(arr[i][j++]==2){
                return false;
            }
        }

        //x+1 y-1
        i = x;
        j = y;
        for(; i<N && j>0; i++){
            if(arr[i][j--]==2)
                return false;
        }

        //x-1 y+1
        i = x;
        j = y;
        for(; i>0 && j<N; i--){
            if(arr[i][j++]==2)
                return false;
        }

        //x-1 y-1
        i = x;
        j = y;
        for(; i>0 && j>0; i--){
            if(arr[i][j--]==2)
                return false;
        }

        return true;
    }
}
