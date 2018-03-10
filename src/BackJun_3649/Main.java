package BackJun_3649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int X;
    static long N;
    static long[] arr;
    static List<Integer> dp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(reader.readLine());
        N = Integer.parseInt(reader.readLine());

        arr = new long[(int)N];
        dp = new ArrayList<>();

        for(int i=0; i<arr.length; i++)
            arr[i] = Integer.parseInt(reader.readLine());

        Arrays.sort(arr);
        int x=0;
        int y=0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length/2; i++){
            if(X*10000000 == arr[i]+arr[arr.length-i-1]){
                dp.add((int)(arr[i]+arr[arr.length-i-1]));
                if(max<arr[i]+arr[arr.length-i-1]){
                    max = (int)(arr[i]+arr[arr.length-i-1]);
                    x = i;
                    y = arr.length-i-1;
                }
            }
        }

        if(dp.isEmpty()){
            System.out.println("danger");
        }else{
            System.out.println("yes " + arr[x] + " " + arr[y]);
        }

    }
}
