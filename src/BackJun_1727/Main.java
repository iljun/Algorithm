package BackJun_1727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int M;
    static int[] longger;
    static int[] shortter;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = reader.readLine().split(" ");

        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        if (N > M) {

            longger = new int[N];
            shortter = new int[M];

            arr = new int[M][N];

            String[] mans = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                longger[i] = Integer.parseInt(mans[i]);
            }

            String[] womans = reader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                shortter[i] = Integer.parseInt(womans[i]);
            }
        }else{
            longger = new int[M];
            shortter = new int[N];

            arr = new int[N][M];

            String[] mans = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                shortter[i] = Integer.parseInt(mans[i]);
            }

            String[] womans = reader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                longger[i] = Integer.parseInt(womans[i]);
            }
        }

        Arrays.sort(longger);
        Arrays.sort(shortter);

        for(int i=0; i<shortter.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j =i; j <= longger.length - shortter.length + i; j++){
                if(i == 0){
                    min = Math.min(min, Math.abs(longger[j] - shortter[i]));
                    arr[i][j] = min;
                }else{
                    min = Math.min(min, Math.abs(longger[j] - shortter[i]) + arr[i-1][j-1]);
                    arr[i][j] = min;
                }
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(arr[shortter.length-1][longger.length-1]);
    }
}