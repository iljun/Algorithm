package BOJ_9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String N;
    static String M;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = reader.readLine();
        M = reader.readLine();

        int[][] lcs = new int[N.length()+1][M.length()+1];

        for(int i=1; i<N.length()+1; i++){
            for(int j=1; j<M.length()+1; j++){
                if(N.charAt(i-1)==M.charAt(j-1)){
                    lcs[i][j]=lcs[i-1][j-1]+1;
                }else {
                    lcs[i][j] = Math.max(lcs[i][j-1],lcs[i-1][j]);
                }
            }
        }

        System.out.println(lcs[N.length()][M.length()]);
    }
}
