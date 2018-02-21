package BackJun_3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int H;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] NH = reader.readLine().split(" ");
        N = Integer.parseInt(NH[0]);
        H = Integer.parseInt(NH[1]);
        arr = new int[2][H];

        for (int i = 0; i < N/2; i++) {
            int bottom = Integer.parseInt(reader.readLine());
            int top = Integer.parseInt(reader.readLine());
            init(0,bottom);
            init(1,H-top+1);
        }

        int[] sum = new int[H];
        for(int i=0; i<H; i++){
            sum[i]= arr[0][i]+arr[1][H-i-1];
        }
        int minCount = 1;
        int block = sum[0];

        for(int i=1; i<H; i++){
            if(block>sum[i]){
                block = sum[i];
                minCount=1;
            }else if(block==sum[i])
                minCount++;
        }

        System.out.println(block + " " + minCount);
    }

    public static void init(int index, int height){
        for(int i=0; i<height; i++){
            arr[index][i]++;
        }
    }
}
