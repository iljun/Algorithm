package BackJun_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new long[N];
        for(int i=0; i<N; i++)
            arr[i] = Long.parseLong(reader.readLine());

        Arrays.sort(arr);

        int count=1;
        int max=1;
        Long maxs = arr[0];
        for(int i=1; i<N; i++){
            if(arr[i-1]==arr[i]){
                count++;
            }else{
                count=1;
            }

            if(count>max){
                max= count;
                maxs = arr[i];
            }
        }
        System.out.println(maxs);
    }
}
