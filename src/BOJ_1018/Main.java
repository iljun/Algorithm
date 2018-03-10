package BOJ_1018;

import java.io.*;

public class Main {
    static int N;
    static int M;
    static String[][] arr;
    static String[][][] chess;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = reader.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        chess = new String[2][8][8];
        arr = new String[N][M];

        for(int i=0; i<2; i++){//초기화
            for(int j=0; j<8; j++){
                if(i==0){
                    if(j%2==0){
                        chess[i][j]=BW();
                    }else{
                        chess[i][j]=WB();
                    }
                }else{
                    if(j%2==0){
                        chess[i][j]=WB();
                    }else{
                        chess[i][j]=BW();
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            String[] input = reader.readLine().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = input[j];
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                for(int k=0; k<2; k++) {
                    min = Math.min(min,calculate(i, j, chess[k]));
                }
            }
        }

        System.out.println(min);
    }

    static String[] BW(){
        return new String[]{"B","W","B","W","B","W","B","W"};
    }

    static String[] WB(){
        return new String[]{"W","B","W","B","W","B","W","B"};
    }

    static int calculate(int x, int y, String[][] arr2){
        int cnt=0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(!arr[i+x][j+y].equals(arr2[i][j]))
                    cnt++;
            }
        }
        return cnt;
    }
}
